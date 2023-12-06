package com.plusappslc.plusfit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * FirebaseAuthRepository é uma classe responsável por lidar com operações relacionadas à autenticação
 * utilizando o Firebase Authentication.
 *
 * @property TAG Uma constante que representa a tag para mensagens de log relacionadas a esta classe.
 */
private const val TAG = "FirebaseAuthRepository"

/**
 * A classe FirebaseAuthRepository contém métodos para operações comuns de autenticação,
 * como cadastro de usuário, login, verificação do estado de login e logout.
 */
class FirebaseAuthRepository(private val firebaseAuth: FirebaseAuth) {


    /**
     * Registra um novo usuário usando o Firebase Authentication.
     *
     * @param email O endereço de e-mail do usuário para cadastro.
     * @param senha A senha do usuário para cadastro.
     */
    fun cadastrarUsuario(email: String, senha: String): LiveData<Resource<Boolean>> {
        val liveData = MutableLiveData<Resource<Boolean>>()
        try {
            firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnFailureListener { execption ->
                    Log.e(TAG, "Falha ao tentar cadastrar usuário", execption)
                  val mensagemErro : String =  when (execption) {
                        is FirebaseAuthWeakPasswordException -> "Senha precisa ter no mínimo 6 digitos, tente novamente!"
                        is FirebaseAuthInvalidCredentialsException -> "E-mail inválido, tente novamente"
                      is FirebaseAuthUserCollisionException -> "E-mail já cadastrado"

                      else -> "Ocorreu um erro inesperado, tente novamente em alguns instantes"
                    }
                    liveData.value = Resource(false, mensagemErro)
                }
                .addOnSuccessListener {
                    Log.i(TAG, "Usuario cadastrado com sucesso")
                    liveData.value = Resource(true, )
                    CoroutineScope(IO).launch {

                    }


                }
        } catch (e: IllegalArgumentException) {
            liveData.value = Resource(false,erro = "Campo de E-mail e senha não podem estar vazios" )
        }
        return liveData
    }


    /**
     * Realiza o login do usuário usando o Firebase Authentication.
     *
     * @param email O endereço de e-mail do usuário para login.
     * @param senha A senha do usuário para login.
     */
    fun logarUsuario(email: String, senha: String) {
        val task = firebaseAuth.signInWithEmailAndPassword(
            email,
            senha
        ).addOnFailureListener { erro ->
            Log.e(TAG, "Falha ao tentar realizar login", erro)
        }
    }

    /**
     * Verifica se um usuário está atualmente autenticado.
     *
     * @return true se um usuário estiver autenticado, false caso contrário.
     */
    fun isUserLogado(): Boolean {
        val usuarioAtual = firebaseAuth.currentUser
        return usuarioAtual != null
    }

    /**
     * Realiza o logout do usuário atual.
     *
     */
    fun userSingOut() {
        firebaseAuth.signOut()
    }
}
