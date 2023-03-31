package com.raion.incareer.presentation.ui.navigation

sealed class Screen(val route: String){

    object Splash: Screen("splash_screen")
    object Login: Screen("login_screen")
    object OnBoarding: Screen ("on_boarding_screen")
}
