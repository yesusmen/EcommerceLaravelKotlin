package com.codeboss.ecommercelaravelkotlin.domain.useCases.auth

import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository

class SaveSessionUseCase constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)

}