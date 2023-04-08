package com.raion.incareer.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.raion.incareer.presentation.bottombar.BottomNavItem
import com.raion.incareer.presentation.bottombar.BottomNavigationBar
import com.raion.incareer.presentation.bottombar.Navigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.MyJobs,
                    BottomNavItem.Company,
                    BottomNavItem.Profile
                ),
                navController = navController,
                onItemClick = {
                    navController.popBackStack()
                    navController.navigate(it.route)
                },
            )
        }
    ){
        Navigation(navController = navController)
    }
}

