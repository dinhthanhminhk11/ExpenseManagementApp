package com.example.expensemanagementapp.usercase

import com.example.expensemanagementapp.constant.Resource
import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.model.response.UserRegisterResponse
import com.example.expensemanagementapp.repository.Repository

class RegisterUseCase(private val repository: Repository) {
    suspend fun execute(bodyRegister: BodyRegister): Resource<UserRegisterResponse> {
        return repository.register(bodyRegister)
    }

    suspend fun executeGenerateOTP(emailBody: EmailBody): Resource<Message> {
        return repository.sendOTPByMail(emailBody)
    }

    suspend fun executeVerifyAccount(bodyVerifyOTP: BodyVerifyOTP): Resource<Message> {
        return repository.verifyRegister(bodyVerifyOTP)
    }
}