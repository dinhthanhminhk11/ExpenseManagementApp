package com.example.expensemanagementapp.ui.fragment.login

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentComfirmOTPBinding
import com.example.expensemanagementapp.databinding.FragmentSuccessNewPasswordBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class SuccessNewPasswordFragment :
    BaseViewModelFragment<FragmentSuccessNewPasswordBinding, MainViewModel>() {

    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun initView() {
        requireActivity().window.statusBarColor = Color.WHITE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        // trạng thái tối
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//            activity?.window?.decorView?.systemUiVisibility = 0
    }

        override fun initOnClickListener() {

    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentSuccessNewPasswordBinding {
        return FragmentSuccessNewPasswordBinding.inflate(inflater, container, false)
    }

}