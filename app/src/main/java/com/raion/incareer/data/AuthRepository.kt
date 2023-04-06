package com.raion.incareer.data

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.raion.incareer.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class AuthRepository (private val firebaseAuth: FirebaseAuth)  {

    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow{
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }

    }

    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow{
            emit(Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    fun resetPassword(email: String): Flow<Resource<Void>>{
        return flow{
            emit(Resource.Loading())
            val result = firebaseAuth.sendPasswordResetEmail(email).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

}