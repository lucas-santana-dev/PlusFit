package com.plusappslc.plusfit.repository

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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
class FirebaseAuthRepository() {

    val firebaseAuth = Firebase.auth

    /**
     * Registra um novo usuário usando o Firebase Authentication.
     *
     * @param email O endereço de e-mail do usuário para cadastro.
     * @param senha A senha do usuário para cadastro.
     */
    fun cadastrarUsuario(email: String, senha: String): Boolean {
        var isCadastrado = mutableStateOf(false)
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
            .addOnFailureListener {
                Log.e(TAG, "Falha ao tentar cadastrar usuário", it)
                isCadastrado.value = false
            }
            .addOnSuccessListener {
                isCadastrado.value = true
            }
        return isCadastrado.value
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
