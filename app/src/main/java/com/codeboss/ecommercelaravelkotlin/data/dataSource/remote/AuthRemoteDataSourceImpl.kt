package com.codeboss.ecommercelaravelkotlin.data.dataSource.remote

import com.codeboss.ecommercelaravelkotlin.data.dataSource.remote.service.AuthService
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.model.LoginRequest
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(
        email: String,
        password: String
    ): Response<AuthResponse> = authService.login(LoginRequest(email, password))
}