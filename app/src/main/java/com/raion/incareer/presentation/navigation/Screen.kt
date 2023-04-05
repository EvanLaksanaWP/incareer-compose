package com.raion.incareer.presentation.navigation

sealed class Screen(val route: String){

    object Splash: Screen("splash_screen")
    object OnBoarding: Screen("on_boarding_screen")

    object Login: Screen("login_screen")
    object Register: Screen ("register_screen")
}
