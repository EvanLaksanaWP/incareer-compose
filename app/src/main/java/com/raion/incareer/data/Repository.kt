package com.raion.incareer.data


class Repository (private val userPreference: UserPreference){

    fun readOnBoardingState() = userPreference.readOnBoardingState()

    suspend fun saveOnBoardingState(isCompleted: Boolean) = userPreference.saveOnBoardingState(isCompleted)
}