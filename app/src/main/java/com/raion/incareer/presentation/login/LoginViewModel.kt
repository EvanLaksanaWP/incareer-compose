package com.raion.incareer.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.Repository
import com.raion.incareer.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository): ViewModel(){

    private val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{ result ->
            when (result){
                is Resource.Success -> {
                    _loginState.send(LoginState(isSuccess = "Login Success"))
                    repository.saveUid(result.data?.user?.uid.toString())
                }
                is Resource.Loading ->{
                    _loginState.send(LoginState(isLoading = true))
                }
                is Resource.Error ->{
                    _loginState.send(LoginState(isError = result.message))
                }
                else -> {}
            }
        }
    }

}