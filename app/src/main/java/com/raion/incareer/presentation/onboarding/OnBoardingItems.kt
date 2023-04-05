package com.raion.incareer.presentation.onboarding

import androidx.annotation.DrawableRes
import com.raion.incareer.R

sealed class OnBoardingItems (
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
    ) {
    object FirstPage: OnBoardingItems(
        image = R.drawable.image_onboarding_page1,
        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Diam maecenas mi non sed.",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Diam maecenas mi non sed ut odio. Non, justo, sed facilisi et. "
    )

    object SecondPage: OnBoardingItems(
        image = R.drawable.image_onboarding_page2,
        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Diam maecenas mi non sed.",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Diam maecenas mi non sed ut odio. Non, justo, sed facilisi et. "
    )

    object ThirdPage: OnBoardingItems(
        image = R.drawable.image_onboarding_page3,
        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Diam maecenas mi non sed.",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Diam maecenas mi non sed ut odio. Non, justo, sed facilisi et. "
    )

}