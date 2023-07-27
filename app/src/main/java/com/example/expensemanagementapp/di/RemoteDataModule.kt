package com.example.expensemanagementapp.di

import com.example.expensemanagementapp.api.ApiRequest
import com.example.expensemanagementapp.repository.dataSource.ApiRequestRemoteDataSource
import com.example.expensemanagementapp.repository.dataSourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun providesRemoteDateSource(apiRequest: ApiRequest): ApiRequestRemoteDataSource {
        return RemoteDataSourceImpl(apiRequest)
    }
}