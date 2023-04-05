package com.raion.incareer.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.AuthRepository
import com.raion.incareer.data.Repository
import com.raion.incareer.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: Repository): ViewModel(){

    private val _registerState = Channel<RegisterState>()
    val registerState = _registerState.receiveAsFlow()

    fun registerUser(email: String, password: String) = viewModelScope.launch {
        repository.registerUser(email, password).collect{ result ->
            when (result){
                is Resource.Success -> {
                    _registerState.send(RegisterState(isSuccess = "Register Success"))


                }
                is Resource.Loading ->{
                    _registerState.send(RegisterState(isLoading = true))
                }
                is Resource.Error ->{
                    _registerState.send(RegisterState(isError = result.message))
                }
            }
        }
    }

}