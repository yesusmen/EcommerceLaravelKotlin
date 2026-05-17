package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboss.ecommercelaravelkotlin.core.Config
import com.codeboss.ecommercelaravelkotlin.data.service.AuthService
import com.codeboss.ecommercelaravelkotlin.domain.model.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var hiddePassword by mutableStateOf(true)

    var errorMessage by mutableStateOf("")

    fun onChangeEmail(email: String){
        state = state.copy(email = email)
    }

    fun onChangePassword(password: String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()){
            val retrofit = Retrofit
                .Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val authService = retrofit.create(AuthService::class.java)
            val result = authService.login(LoginRequest(state.email, state.password))
            Log.d("LoginViewModel", "Result: ${result.body()}")
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