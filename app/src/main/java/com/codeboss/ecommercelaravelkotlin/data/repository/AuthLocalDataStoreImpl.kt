package com.codeboss.ecommercelaravelkotlin.data.repository

import com.codeboss.ecommercelaravelkotlin.data.dataSource.local.AuthDataStore
import com.codeboss.ecommercelaravelkotlin.data.dataSource.local.AuthLocalDataStore
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class AuthLocalDataStoreImpl constructor(private val authDataStore: AuthDataStore): AuthLocalDataStore{

    override suspend fun saveSession(authResponse: AuthResponse)  = authDataStore.saveUser(authResponse)
    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}