package com.codeboss.ecommercelaravelkotlin.data.dataSource.local

import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataStore {

    suspend fun saveSession(authResponse: AuthResponse)

    suspend fun logout()

    fun getSessionData(): Flow<AuthResponse>
}