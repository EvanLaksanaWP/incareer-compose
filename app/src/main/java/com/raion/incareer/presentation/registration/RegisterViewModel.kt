package com.raion.incareer.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
    private var db = Firebase.firestore

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

    fun saveDataUser(fullName: String, email: String) = viewModelScope.launch {
        val userMap = hashMapOf(
            "Nama Lengkap" to fullName,
            "Email" to email
        )
        val userid = FirebaseAuth.getInstance().currentUser!!.uid

        db.collection("User").document(email).set(userMap)
    }
}

