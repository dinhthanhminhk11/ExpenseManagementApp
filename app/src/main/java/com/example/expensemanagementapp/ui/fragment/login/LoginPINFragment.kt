package com.example.expensemanagementapp.ui.fragment.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentLoginPINBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel


class LoginPINFragment : BaseViewModelFragment<FragmentLoginPINBinding, MainViewModel>() {

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
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentLoginPINBinding {
        return FragmentLoginPINBinding.inflate(inflater, container, false)
    }

}