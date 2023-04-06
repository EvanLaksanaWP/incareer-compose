package com.raion.incareer.presentation.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.Repository
import com.raion.incareer.presentation.login.LoginState
import com.raion.incareer.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val repository: Repository): ViewModel(){

    private val _resetPasswordState = Channel<ResetPasswordState>()
    val resetPasswordState = _resetPasswordState.receiveAsFlow()

    fun resetPassword(email: String) {
        viewModelScope.launch {
            repository.resetPassword(email).collect { result ->
                when (result){
                    is Resource.Success -> {
                        _resetPasswordState.send(ResetPasswordState(isSuccess = "Reset password email has been sent successfully"))
                    }
                    is Resource.Loading -> {
                        _resetPasswordState.send(ResetPasswordState(isLoading = true))
                    }
                    is Resource.Error -> {
                        _resetPasswordState.send(ResetPasswordState(isError = result.message))
                    }
                    else -> {}
                }
            }
        }
    }

}