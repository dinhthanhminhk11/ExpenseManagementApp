package com.example.expensemanagementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.expensemanagementapp.viewmodel.MainViewModel
import com.example.expensemanagementapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var factory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
}