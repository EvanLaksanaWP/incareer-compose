package com.raion.incareer.presentation.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.raion.incareer.presentation.company.CompanyScreen
import com.raion.incareer.presentation.home.HomeScreen
import com.raion.incareer.presentation.myjob.MyJob
import com.raion.incareer.presentation.navigation.Screen
import com.raion.incareer.presentation.profile.ProfileScreen

@Composable
fun Navigation (navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeScreen()
        }
        composable(Screen.MyJob.route){
            MyJob()
        }
        composable(Screen.Company.route){
            CompanyScreen()
        }
        composable(Screen.Profile.route){
            ProfileScreen()
        }
    }
}