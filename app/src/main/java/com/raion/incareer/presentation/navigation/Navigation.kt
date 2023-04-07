package com.raion.incareer.presentation.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raion.incareer.presentation.company.CompanyScreen
import com.raion.incareer.presentation.forgotpassword.ForgotPasswordScreen
import com.raion.incareer.presentation.home.HomeScreen
import com.raion.incareer.presentation.main.MainScreen
import com.raion.incareer.presentation.myjob.MyJob
import com.raion.incareer.presentation.splash.SplashScreen
import com.raion.incareer.presentation.onboarding.OnBoardingScreen
import com.raion.incareer.presentation.profile.ProfileScreen
import com.raion.incareer.presentation.registration.RegisterScreen

@Composable
fun Navigation() {
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
            LoginScreen(navController = navController)
        }
        composable(Screen.Register.route){
            RegisterScreen(navController = navController)
        }
        composable(Screen.ForgotPassword.route){
            ForgotPasswordScreen(navController = navController)
        }
        composable(Screen.Main.route){
            MainScreen()
        }
    }
}