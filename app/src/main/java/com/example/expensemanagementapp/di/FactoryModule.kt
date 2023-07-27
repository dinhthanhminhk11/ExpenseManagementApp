package com.example.expensemanagementapp.di

import android.app.Application
import com.example.expensemanagementapp.usercase.LoginUserCase
import com.example.expensemanagementapp.usercase.RegisterUseCase
import com.example.expensemanagementapp.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun providerViewModelFactory(
        application: Application,
        loginUserCase: LoginUserCase,
        registerUseCase: RegisterUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(application, loginUserCase,registerUseCase)
    }
}