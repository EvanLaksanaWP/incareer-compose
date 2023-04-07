package com.raion.incareer.presentation.bottombar

import androidx.annotation.DrawableRes
import com.raion.incareer.R


sealed class BottomNavItem(
    val route: String,
    val title: String,
    @DrawableRes
    val image: Int
  )
{
    object Home: BottomNavItem(
        route = "home_screen",
        title = "Home",
        image = R.drawable.home_icon
    )
    object MyJobs: BottomNavItem(
        route = "my_jobs_screen",
        title = "My Jobs",
        image = R.drawable.job_icon
    )
    object Company: BottomNavItem(
        route = "company_screen",
        title = "Home",
        image = R.drawable.company_icon
    )
    object Profile: BottomNavItem(
        route = "profile_screen",
        title = "Home",
        image = R.drawable.profile_icon
    )
}