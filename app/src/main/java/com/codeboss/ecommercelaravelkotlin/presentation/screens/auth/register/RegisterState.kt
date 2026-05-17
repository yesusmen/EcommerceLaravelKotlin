package com.codeboss.ecommercelaravelkotlin.presentation.screens.auth.register

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
