package com.raion.incareer.presentation.registration

data class RegisterState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
