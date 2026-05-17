package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var hiddenPassword by mutableStateOf(true)

    var hiddenConfirmPassword by mutableStateOf(true)

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