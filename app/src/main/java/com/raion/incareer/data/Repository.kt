package com.raion.incareer.data

import com.raion.incareer.data.dummy.Company
import com.raion.incareer.data.dummy.Job
import com.raion.incareer.data.dummy.User


class Repository (
    private val userPreference: UserPreference,
    private val authRepository: AuthRepository,
){
    fun readOnBoardingState() = userPreference.readOnBoardingState()

    suspend fun saveOnBoardingState(isCompleted: Boolean) = userPreference.saveOnBoardingState(isCompleted)

    fun loginUser(email: String, password: String) = authRepository.loginUser(email, password)

    fun registerUser(email: String, password: String) = authRepository.registerUser(email, password)

    fun resetPassword(email: String) = authRepository.resetPassword(email)

    suspend fun saveUid(uid: String) = userPreference.saveUid(uid)

    fun readUid() = userPreference.readUid
}