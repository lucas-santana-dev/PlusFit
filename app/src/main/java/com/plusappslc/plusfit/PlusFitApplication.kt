package com.plusappslc.plusfit

import android.app.Application
import com.plusappslc.plusfit.di.modules.appModule
import com.plusappslc.plusfit.di.modules.databaseModule
import com.plusappslc.plusfit.di.modules.firebaseAuthModule
import org.koin.core.context.startKoin

class PlusFitApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(appModule,firebaseAuthModule, databaseModule)
        }
    }
}