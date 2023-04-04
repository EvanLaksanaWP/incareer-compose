package com.raion.incareer.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnBoardingViewModel(private val repository: Repository): ViewModel(){
    fun saveOnBoardingState(isCompleted: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(isCompleted)
        }
    }
}