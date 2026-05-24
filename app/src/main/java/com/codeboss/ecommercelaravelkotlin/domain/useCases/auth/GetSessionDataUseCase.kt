package com.codeboss.ecommercelaravelkotlin.domain.useCases.auth

import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(
    private val repository: AuthRepository
) {

    operator fun invoke() = repository.getSessionData()

}