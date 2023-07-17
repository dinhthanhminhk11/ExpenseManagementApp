package com.example.expensemanagementapp.repository

import com.example.expensemanagementapp.constant.Resource
import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.model.response.UserRegisterResponse

interface Repository {
    suspend fun register(bodyRegister: BodyRegister): Resource<UserRegisterResponse>

    suspend fun login(bodyLogin: BodyLogin): Resource<UserLoginResponse>

    suspend fun verifyRegister(bodyVerifyOTP: BodyVerifyOTP): Resource<Message>

    suspend fun sendOTPByMail(emailBody: EmailBody): Resource<Message>
}