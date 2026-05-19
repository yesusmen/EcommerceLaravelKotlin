package com.codeboss.ecommercelaravelkotlin.di

import com.codeboss.ecommercelaravelkotlin.data.dataSource.remote.AuthRemoteDataSource
import com.codeboss.ecommercelaravelkotlin.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.codeboss.ecommercelaravelkotlin.data.repository.AuthRepositoryImpl
import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)

}