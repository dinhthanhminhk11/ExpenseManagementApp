package com.example.expensemanagementapp.ui.fragment.login

import android.graphics.Paint
import android.os.Bundle
import android.os.CountDownTimer
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
    private lateinit var countdownTimer: CountDownTimer

    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {
        binding.downTime.paintFlags = binding.downTime.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        val otpValidityDurationInMillis: Long =
            60000

        countdownTimer = object : CountDownTimer(otpValidityDurationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val downTime = String.format("%d:%02d", minutes, seconds)
                val formattedTime = downTime.toString()
                binding.downTime.text = formattedTime
            }

            override fun onFinish() {
                binding.downTime.text = getString(R.string.sendAgain)
                // Xử lý khi kết thúc đếm ngược (ví dụ: gửi lại OTP, hiển thị thông báo...)
            }
        }

        countdownTimer.start()
    }

    override fun initOnClickListener() {

    }

    override fun observeLiveData() {

    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentComfirmOTPBinding {
        return FragmentComfirmOTPBinding.inflate(inflater, container, false)
    }
}