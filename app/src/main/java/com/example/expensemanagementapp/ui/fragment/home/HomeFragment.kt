package com.example.expensemanagementapp.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentHomeBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class HomeFragment : BaseViewModelFragment<FragmentHomeBinding, MainViewModel>() {
    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {

    }

    override fun initOnClickListener() {
    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

}