package com.plusappslc.plusfit.ui.screens.cadastrousuario

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.plusappslc.plusfit.repository.FirebaseAuthRepository

private const val TAG = "CadastroUsuarioViewModel"

class CadastroUsuarioViewModel : ViewModel() {

    private val firebaseAuthRepository = FirebaseAuthRepository()

    var passwordVisible = mutableStateOf(false)
    var password = mutableStateOf("")
    var passwordConfirmation = mutableStateOf("")
    var email = mutableStateOf("")
    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun cadastrarUsuario() {

        Log.d(TAG,"Email ${email} Senha $password")
        val cadastrarUsuario = firebaseAuthRepository
            .cadastrarUsuario(
                email.value,
                password.value
            )
        if (cadastrarUsuario){
            Log.d(TAG,"Cadastrado")
        }else{
            Log.d(TAG,"Não Cadastrado")

        }
    }

}
