package com.codeboss.ecommercelaravelkotlin.domain.useCases.auth

import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository

class RegisterUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.register(user)

}