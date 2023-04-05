package com.raion.incareer

import android.app.Application
import com.raion.incareer.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class IncareerApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@IncareerApplication)
            modules(
                userPreferenceModule,
                repositoryModule,
                viewModelModule,
                firebaseAuthModule,
                authRepositoryImplModule
            )
        }
    }
}