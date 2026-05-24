package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.AuthUseCase
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var hiddePassword by mutableStateOf(true)

    var errorMessage by mutableStateOf("")

    var loginResource by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun onChangeEmail(email: String){
        state = state.copy(email = email)
    }

    fun onChangePassword(password: String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()){
            loginResource = Resource.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResource = result
            Log.d("LoginViewModel", "Result: $loginResource")
        }
    }

    fun isValidForm(): Boolean  {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El correo electrónico no es valido"
            return false
        }
        else if (state.password.length < 8) {
            errorMessage = "La contraseña debe tener al menos 8 caracteres"
            return false
        }

        return true
    }

}