package com.codeboss.ecommercelaravelkotlin.data.dataSource.remote.service

import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.model.LoginRequest
import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.google.gson.annotations.JsonAdapter
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(@Body user: User): Response<AuthResponse>

}