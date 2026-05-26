package com.codeboss.ecommercelaravelkotlin.domain.useCases.auth

import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}