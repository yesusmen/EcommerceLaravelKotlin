package com.codeboss.ecommercelaravelkotlin.data.dataSource.remote

import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>

}