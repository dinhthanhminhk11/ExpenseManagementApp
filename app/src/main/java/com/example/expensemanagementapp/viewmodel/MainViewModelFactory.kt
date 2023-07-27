package com.example.expensemanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expensemanagementapp.usercase.LoginUserCase
import com.example.expensemanagementapp.usercase.RegisterUseCase

class MainViewModelFactory(
    private val application: Application,
    private val loginUserCase: LoginUserCase,
    private val registerUseCase: RegisterUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application, loginUserCase ,registerUseCase) as T
    }
}