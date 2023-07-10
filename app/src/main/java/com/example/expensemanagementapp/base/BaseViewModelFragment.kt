package com.example.expensemanagementapp.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


abstract class BaseViewModelFragment<Binding : ViewBinding, VM : ViewModel> :
    BaseFragment<Binding>() {

    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initOnClickListener()
        observeLiveData()
    }

    abstract fun initView()
    abstract fun initOnClickListener()
    abstract fun observeLiveData()

}