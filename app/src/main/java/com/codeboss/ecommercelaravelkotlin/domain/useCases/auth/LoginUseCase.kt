package com.codeboss.ecommercelaravelkotlin.domain.useCases.auth

import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase constructor(private val repository: AuthRepository){

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}