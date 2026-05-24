package com.codeboss.ecommercelaravelkotlin.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(repository: AuthRepository): ViewModel() {

    val tokenUser: StateFlow<AuthResponse?> = repository.getSessionData().stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        null
    )

}