package com.example.expensemanagementapp.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentPersonBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class PersonFragment : BaseViewModelFragment<FragmentPersonBinding, MainViewModel>() {
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
    ): FragmentPersonBinding {
        return FragmentPersonBinding.inflate(inflater, container, false)
    }

}