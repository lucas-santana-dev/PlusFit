package com.plusappslc.plusfit.di.modules

import com.google.firebase.auth.FirebaseAuth
import com.plusappslc.plusfit.repository.FirebaseAuthRepository
import com.plusappslc.plusfit.ui.screens.cadastrousuario.CadastroUsuarioViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module{

    singleOf(::FirebaseAuthRepository)
    viewModelOf(::CadastroUsuarioViewModel)
}

val firebaseAuthModule = module {
    single { FirebaseAuth.getInstance() }
}