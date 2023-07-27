package com.example.expensemanagementapp.di

import com.example.expensemanagementapp.repository.Repository
import com.example.expensemanagementapp.repository.RepositoryImpl
import com.example.expensemanagementapp.repository.dataSource.ApiRequestRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(apiRequestRemoteDataSource: ApiRequestRemoteDataSource): Repository {
        return RepositoryImpl(apiRequestRemoteDataSource)
    }
}