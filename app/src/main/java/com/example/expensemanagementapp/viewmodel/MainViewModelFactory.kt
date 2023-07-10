package com.example.expensemanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(
    private val application: Application,
    /*    private val homeBookingUseCase: HomeBookingUseCase*/
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application/*, homeBookingUseCase*/) as T
    }
}