package com.raion.incareer.presentation.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raion.incareer.presentation.ui.screens.SplashScreen
import com.raion.incareer.presentation.ui.screens.OnBoardingScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.OnBoarding.route){
            OnBoardingScreen(navController = navController)
        }
        composable(Screen.Login.route){
            LoginScreen()
        }
    }
}