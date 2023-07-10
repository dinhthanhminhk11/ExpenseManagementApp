package com.example.expensemanagementapp.ui.fragment.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentRegisterBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel


class RegisterFragment : BaseViewModelFragment<FragmentRegisterBinding, MainViewModel>() {
    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {

    }

    override fun initOnClickListener() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_comfirmOTPFragment)
        }
    }

    override fun observeLiveData() {
    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(inflater, container, false)
    }

}