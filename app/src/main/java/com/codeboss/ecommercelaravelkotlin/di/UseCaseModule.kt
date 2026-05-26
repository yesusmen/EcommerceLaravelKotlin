package com.codeboss.ecommercelaravelkotlin.di

import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.AuthUseCase
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.GetSessionDataUseCase
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.LoginUseCase
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.LogoutUseCase
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.RegisterUseCase
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.SaveSessionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
    )

}