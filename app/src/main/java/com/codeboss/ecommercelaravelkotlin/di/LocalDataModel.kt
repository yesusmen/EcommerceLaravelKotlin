package com.codeboss.ecommercelaravelkotlin.di

import com.codeboss.ecommercelaravelkotlin.data.dataSource.local.AuthDataStore
import com.codeboss.ecommercelaravelkotlin.data.dataSource.local.AuthLocalDataStore
import com.codeboss.ecommercelaravelkotlin.data.repository.AuthLocalDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.internal.TestSingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModel {


    @Provides
    fun provideAuthLocalDataStore(authDataStore: AuthDataStore): AuthLocalDataStore =
        AuthLocalDataStoreImpl(authDataStore)


}