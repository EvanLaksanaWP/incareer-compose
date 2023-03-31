package com.raion.incareer.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val repository: Repository): ViewModel(){
    fun saveOnBoardingState(isCompleted: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(isCompleted)
        }
    }
}