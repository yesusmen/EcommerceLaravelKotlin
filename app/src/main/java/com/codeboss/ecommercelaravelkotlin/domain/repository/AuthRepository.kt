package com.codeboss.ecommercelaravelkotlin.domain.repository

import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource


interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>

}