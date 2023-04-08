package com.raion.incareer.data.dummy

import androidx.annotation.DrawableRes
import com.raion.incareer.R

data class User(
    var username: String,
    var fullName: String,
    @DrawableRes
    var profilePicture: Int,
    var birthDate: String
)
val user: User = User(
    username = "Fatihevan",
    fullName = "Evan Fatih Wira Raka",
    profilePicture = R.drawable.user_image,
    birthDate = "01/01/2003"
)


