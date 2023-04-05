package com.raion.incareer.data


class Repository (
    private val userPreference: UserPreference,
    private val authRepository: AuthRepository
){
    fun readOnBoardingState() = userPreference.readOnBoardingState()

    suspend fun saveOnBoardingState(isCompleted: Boolean) = userPreference.saveOnBoardingState(isCompleted)

    fun loginUser(email: String, password: String) = authRepository.loginUser(email, password)

    fun registerUser(email: String, password: String) = authRepository.registerUser(email, password)

    suspend fun saveUid(uid: String) = userPreference.saveUid(uid)

    fun readUid() = userPreference.readUid

}