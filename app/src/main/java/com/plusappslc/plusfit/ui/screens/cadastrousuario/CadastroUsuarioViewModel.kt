package com.plusappslc.plusfit.ui.screens.cadastrousuario

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.plusappslc.plusfit.repository.FirebaseAuthRepository
import com.plusappslc.plusfit.repository.Resource

private const val TAG = "CadastroUsuarioViewModel"

class CadastroUsuarioViewModel(private val firebaseAuthRepository: FirebaseAuthRepository) :
    ViewModel() {

    var passwordVisible = mutableStateOf(false)
    var password = mutableStateOf("")
    var passwordConfirmation = mutableStateOf("")
    var email = mutableStateOf("")
    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun cadastrarUsuario(): LiveData<Resource<Boolean>> {
        return firebaseAuthRepository
            .cadastrarUsuario(
                email.value,
                password.value
            )

    }

}
