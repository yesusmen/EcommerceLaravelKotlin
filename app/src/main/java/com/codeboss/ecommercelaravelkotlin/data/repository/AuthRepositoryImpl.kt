package com.codeboss.ecommercelaravelkotlin.data.repository

import com.codeboss.ecommercelaravelkotlin.data.dataSource.remote.AuthRemoteDataSource
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import com.codeboss.ecommercelaravelkotlin.domain.util.Response

import javax.inject.Inject

class AuthRepositoryImpl constructor(private val authRemoteDataSource: AuthRemoteDataSource ): AuthRepository {

    override suspend fun login(email: String, password: String): Response<AuthResponse>{

        return try {
            val result = authRemoteDataSource.login(email, password)
            Response.Success(result.body()!!)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}