package com.raion.incareer.presentation.navigation

sealed class Screen(val route: String){

    object Splash: Screen("splash_screen")
    object OnBoarding: Screen("on_boarding_screen")
    object Login: Screen("login_screen")
    object Register: Screen ("register_screen")
    object ForgotPassword: Screen ("forgot_password_screen")
    object Home: Screen ("home_screen")
    object MyJob: Screen ("my_jobs_screen")
    object Company: Screen ("company_screen")
    object Profile: Screen ("profile_screen")
    object Main: Screen ("main_screen")
}
