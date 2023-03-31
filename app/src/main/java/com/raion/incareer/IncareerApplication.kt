package com.raion.incareer

import android.app.Application
import com.raion.incareer.di.repositoryModule
import com.raion.incareer.di.userPreferenceModule
import com.raion.incareer.di.viewModelModule
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
                viewModelModule
            )
        }
    }
}