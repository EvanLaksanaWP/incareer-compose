package com.raion.incareer.data

import android.content.Context
import javax.inject.Inject

class Repository @Inject constructor(context: Context){
    private val userPreference = UserPreference(context)

    fun readOnBoardingState() = userPreference.readOnBoardingState()

    suspend fun saveOnBoardingState(isCompleted: Boolean) = userPreference.saveOnBoardingState(isCompleted)
}