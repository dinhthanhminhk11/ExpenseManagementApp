package com.example.expensemanagementapp.di

import com.example.expensemanagementapp.repository.Repository
import com.example.expensemanagementapp.usercase.LoginUserCase
import com.example.expensemanagementapp.usercase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideLoginUserCase(repository: Repository): LoginUserCase {
        return LoginUserCase(repository)
    }
    @Singleton
    @Provides
    fun provideRegisterUseCase(repository: Repository): RegisterUseCase =
        RegisterUseCase(repository)
}