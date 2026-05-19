package com.codeboss.ecommercelaravelkotlin.di

import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.AuthUseCase
import com.codeboss.ecommercelaravelkotlin.domain.useCases.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository)
    )

}