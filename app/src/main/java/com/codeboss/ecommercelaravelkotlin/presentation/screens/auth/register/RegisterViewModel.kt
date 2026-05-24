package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.AuthUseCase
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var hiddenPassword by mutableStateOf(true)

    var hiddenConfirmPassword by mutableStateOf(true)

    var registerResource by mutableStateOf<Resource<AuthResponse>?>(null)
        private set


    fun register() = viewModelScope.launch {
        if (isValidateForm()){
            val user = User(
                firstName = state.firstName,
                lastName = state.lastName,
                email = state.email,
                phone = state.phone,
                password = state.password
            )
            registerResource = Resource.Loading
            val result = authUseCase.register(user)
            registerResource = result
            Log.d("RegisterViewModel", "Result: $registerResource")
        }
    }

    fun onChangeFirstName(firstName: String){
        state = state.copy(firstName = firstName)
    }

    fun onChangeLastName(lastName: String){
        state = state.copy(lastName = lastName)
    }

    fun onChangeEmail(email: String){
        state = state.copy(email = email)
    }

    fun onChangePhone(phone: String){
        state = state.copy(phone = phone)
    }

    fun onChangePassword(password: String){
        state = state.copy(password = password)
    }

    fun onChangeConfirmPassword(confirmPassword: String){
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun isValidateForm(): Boolean {
        if (state.firstName.length < 4 ){
            errorMessage = "El Nombre debe tener al menos 4 caracteres"
            return false
        }
        else if (state.lastName.length < 4 ){
            errorMessage = "El Apellido debe tener al menos 4 caracteres"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El correo electrónico no es valido"
            return false
        }
        else if (state.phone.length < 10 ){
            errorMessage = "El Apellido debe tener al menos 12 caracteres"
            return false
        }
        else if (state.password.length < 8) {
            errorMessage = "La contraseña debe tener al menos 8 caracteres"
            return false
        }
        else if (state.password != state.confirmPassword){
            errorMessage = "La contraseñas no coinciden"
            return false
        }

        return true

    }



}