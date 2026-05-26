package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {

    var user by mutableStateOf<User?>(null)

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() {data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch{
        authUseCase.logout()
    }

}