package com.example.expensemanagementapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.databinding.FragmentKingMainBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class KingMainFragment : BaseViewModelFragment<FragmentKingMainBinding, MainViewModel>() {
    private var backPressedTime: Long = 0
    private val BACK_PRESS_INTERVAL: Long = 2000
    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {
        duplicationBack()
    }

    override fun initOnClickListener() {

    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKingMainBinding {
        return FragmentKingMainBinding.inflate(inflater, container, false)
    }

    private fun duplicationBack(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val currentTime = System.currentTimeMillis()
                if (currentTime - backPressedTime > BACK_PRESS_INTERVAL) {
                    Toast.makeText(requireContext(), "Nhấn back lần nữa để thoát", Toast.LENGTH_SHORT).show()
                    backPressedTime = currentTime
                } else {
                    isEnabled = false
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }

}