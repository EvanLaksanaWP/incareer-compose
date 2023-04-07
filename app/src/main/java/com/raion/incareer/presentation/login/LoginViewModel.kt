package com.raion.incareer.presentation.login

import android.app.Activity
import android.content.Context
import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.google.android.gms.auth.api.identity.SignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.raion.incareer.R
import com.raion.incareer.data.Repository
import com.raion.incareer.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.nio.file.Paths.get


class LoginViewModel(private val repository: Repository): ViewModel(){

    private val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()
//    private lateinit var googleSignInClient : GoogleSignInClient
    private lateinit var auth : FirebaseAuth




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