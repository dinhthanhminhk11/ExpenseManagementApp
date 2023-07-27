package com.example.expensemanagementapp.ui.fragment.login

import android.graphics.Paint
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.expensemanagementapp.MainActivity
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.base.BaseViewModelFragment
import com.example.expensemanagementapp.constant.AppConstant
import com.example.expensemanagementapp.constant.Resource
import com.example.expensemanagementapp.databinding.FragmentComfirmOTPBinding
import com.example.expensemanagementapp.viewmodel.MainViewModel

class ConfirmOTPFragment : BaseViewModelFragment<FragmentComfirmOTPBinding, MainViewModel>() {
    private lateinit var countdownTimer: CountDownTimer
    private val otpValidityDurationInMillis: Long = 60000
    private var isLoading = false
    private var emailUser: String? = "ddd"
    override val viewModel: MainViewModel by lazy {
        (activity as MainActivity).viewModel
    }

    override fun initView() {
        arguments?.let {
            emailUser = it.getString(AppConstant.EMAIL_USER)
            binding.toMail.text = getString(R.string.toPhone, emailUser)
        }

        binding.downTime.paintFlags = binding.downTime.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        startCountdownTimer()

        binding.downTime.setOnClickListener {
            countdownTimer.cancel()
            startCountdownTimer()
        }
    }

    override fun initOnClickListener() {
        binding.btnLogin.setOnClickListener {
            binding.otp.setLineColor(resources.getColor(R.color.red))
            binding.otp.setTextColor(resources.getColor(R.color.red))
        }
    }

    override fun observeLiveData() {
//        viewModel.mutableLiveDataMessage.observe(viewLifecycleOwner) { resource ->
//            when (resource) {
//                is Resource.Success -> {
//                    hideProgressBar()
//                    resource.data?.let { message ->
//
//                    }
//                }
//
//                is Resource.Error -> {
//                    hideProgressBar()
//                    resource.message?.let {
//                        Log.i("MYTAG", "An error occurred : $it")
//                    }
//                }
//
//                is Resource.Loading -> {
//                    showProgressBar()
//                }
//            }
//        }
    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentComfirmOTPBinding {
        return FragmentComfirmOTPBinding.inflate(inflater, container, false)
    }

    private fun startCountdownTimer() {
        countdownTimer = object : CountDownTimer(otpValidityDurationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val downTime = String.format("%d:%02d", minutes, seconds)
                binding.downTime.text = downTime
                binding.downTime.isEnabled = false
            }

            override fun onFinish() {
                binding.downTime.text = getString(R.string.sendAgain)
                binding.downTime.isEnabled = true
            }
        }
        countdownTimer.start()
    }

    private fun showProgressBar() {
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
        binding.btnLogin.isEnabled = false
    }

    private fun hideProgressBar() {
        isLoading = false
        binding.progressBar.visibility = View.INVISIBLE
        binding.btnLogin.isEnabled = true
    }
}