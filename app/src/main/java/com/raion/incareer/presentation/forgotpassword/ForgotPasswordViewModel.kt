package com.raion.incareer.presentation.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.Repository
import com.raion.incareer.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val repository: Repository): ViewModel(){

    private val _resetPasswordState: MutableStateFlow<Resource<Unit>> = MutableStateFlow(Resource.Loading())
    val resetPasswordState: StateFlow<Resource<Unit>> get() = _resetPasswordState

    fun resetPassword(email: String) {
        viewModelScope.launch {
            repository.resetPassword(email).collect { result ->
                when (result){
                    is Resource.Success -> {
                        _resetPasswordState.value = Resource.Success(Unit)
                    }
                    is Resource.Loading -> {
                        _resetPasswordState.value = Resource.Loading()
                    }
                    is Resource.Error -> {
                        _resetPasswordState.value = Resource.Error(result.message)
                    }
                }
            }
        }
    }

}