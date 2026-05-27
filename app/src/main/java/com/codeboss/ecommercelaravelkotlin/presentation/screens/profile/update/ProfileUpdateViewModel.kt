package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //ARGUMENTS
    val data = savedStateHandle.get<String>("userParam")
    val user = User.fromJson(data!!)

    init {
        state = state.copy(
            firstName = user.firstName,
            lastName =  user.lastName,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun onChangeFirstName(firstName: String){
        state = state.copy(firstName = firstName)
    }

    fun onChangeLastName(lastName: String){
        state = state.copy(lastName = lastName)
    }

    fun onChangePhone(phone: String){
        state = state.copy(phone = phone)
    }

    fun onChangeImage(image: String){
        state = state.copy(image = image)
    }


}