package com.raion.incareer.presentation.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.raion.incareer.data.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.incareer.presentation.navigation.Screen
import kotlinx.coroutines.launch

class SplashViewModel(private val repository: Repository ): ViewModel(){

    private val _nextDestination: MutableState <String> = mutableStateOf(Screen.OnBoarding.route)

    val nextDestination: State<String> = _nextDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect{ isCompleted ->
                _nextDestination.value =  if (isCompleted) Screen.Login.route else Screen.OnBoarding.route
            }
        }
    }
}