package com.raion.incareer.presentation.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.Repository
import com.raion.incareer.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val repository: Repository): ViewModel(){

    private val _resetPasswordState: MutableStateFlow<Resource<Void>> = MutableStateFlow(Resource.Loading())
    val resetPasswordState: StateFlow<Resource<Void>> get() = _resetPasswordState

    fun resetPassword(email: String) {
        viewModelScope.launch {
            repository.resetPassword(email).collect { result ->
                _resetPasswordState.value = result
            }
        }
    }

}