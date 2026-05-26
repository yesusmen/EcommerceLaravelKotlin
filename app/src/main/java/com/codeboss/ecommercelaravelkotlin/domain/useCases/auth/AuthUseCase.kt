package com.codeboss.ecommercelaravelkotlin.domain.useCases.auth

data class AuthUseCase(

    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutUseCase,

)
