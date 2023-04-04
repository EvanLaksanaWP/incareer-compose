package com.raion.incareer.di
import com.raion.incareer.data.Repository
import com.raion.incareer.data.UserPreference
import com.raion.incareer.presentation.onboarding.OnBoardingViewModel
import com.raion.incareer.presentation.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userPreferenceModule = module {
    single {
        UserPreference(androidApplication())
    }
}

val repositoryModule = module {
    single {
        Repository(get())
    }
}

val viewModelModule = module {
    viewModel {
        SplashViewModel(get())
    }
    viewModel{
        OnBoardingViewModel(get())
    }
}