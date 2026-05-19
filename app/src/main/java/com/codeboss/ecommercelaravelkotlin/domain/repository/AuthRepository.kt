package com.codeboss.ecommercelaravelkotlin.domain.repository

import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.util.Response


interface AuthRepository {

    suspend fun login(email: String, password: String): Response<AuthResponse>

}