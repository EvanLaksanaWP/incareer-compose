package com.raion.incareer.presentation.forgotpassword

data class ResetPasswordState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
