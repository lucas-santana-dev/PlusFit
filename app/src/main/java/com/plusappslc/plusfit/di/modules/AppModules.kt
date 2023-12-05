package com.plusappslc.plusfit.di.modules

import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.plusappslc.plusfit.database.PlusFitDataBase
import com.plusappslc.plusfit.repository.FirebaseAuthRepository
import com.plusappslc.plusfit.ui.screens.cadastrousuario.CadastroUsuarioViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module{

    singleOf(::FirebaseAuthRepository)
    single { Room.databaseBuilder(androidContext(), PlusFitDataBase::class.java, "plusfit.db").build() }
    viewModelOf(::CadastroUsuarioViewModel)
}

val firebaseAuthModule = module {
    single { FirebaseAuth.getInstance() }
}
val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            PlusFitDataBase::class.java,
            "plusfit.db"
        ).build()
    }
}
