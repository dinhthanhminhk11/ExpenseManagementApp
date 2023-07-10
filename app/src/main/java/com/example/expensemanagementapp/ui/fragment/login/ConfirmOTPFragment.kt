package com.example.expensemanagementapp.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentComfirmOTPBinding
import com.example.expensemanagementapp.databinding.FragmentLoginBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class ConfirmOTPFragment : BaseViewModelFragment<FragmentComfirmOTPBinding, MainViewModel>() {
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
    ): FragmentComfirmOTPBinding {
        return FragmentComfirmOTPBinding.inflate(inflater, container, false)
    }
}