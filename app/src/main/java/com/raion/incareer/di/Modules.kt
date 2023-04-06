package com.raion.incareer.di
import com.google.firebase.auth.FirebaseAuth
import com.raion.incareer.data.AuthRepository
import com.raion.incareer.data.Repository
import com.raion.incareer.data.UserPreference
import com.raion.incareer.presentation.forgotpassword.ForgotPasswordViewModel
import com.raion.incareer.presentation.login.LoginViewModel
import com.raion.incareer.presentation.onboarding.OnBoardingViewModel
import com.raion.incareer.presentation.registration.RegisterViewModel
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
        Repository(get(), get())
    }
}

val viewModelModule = module {
    viewModel {
        SplashViewModel(get())
    }
    viewModel{
        OnBoardingViewModel(get())
    }
    viewModel{
        LoginViewModel(get())
    }
    viewModel{
        RegisterViewModel(get())
    }
    viewModel{
        ForgotPasswordViewModel(get())
    }

}

val firebaseAuthModule = module {
    single{
        FirebaseAuth.getInstance()
    }
}

val authRepositoryImplModule = module {
    single {
        AuthRepository(get())
    }
}