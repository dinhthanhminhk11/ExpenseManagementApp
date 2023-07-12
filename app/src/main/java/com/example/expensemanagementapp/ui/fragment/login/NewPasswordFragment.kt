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
import com.example.expensemanagementapp.databinding.FragmentNewPasswordBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class NewPasswordFragment : BaseViewModelFragment<FragmentNewPasswordBinding, MainViewModel>() {

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
    ): FragmentNewPasswordBinding {
        return FragmentNewPasswordBinding.inflate(inflater, container, false)
    }

}