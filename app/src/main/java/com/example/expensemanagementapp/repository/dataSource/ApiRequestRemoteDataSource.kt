package com.example.expensemanagementapp.repository.dataSource

import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.model.response.UserRegisterResponse
import retrofit2.Response

interface ApiRequestRemoteDataSource {
    suspend fun register(bodyRegister: BodyRegister): Response<UserRegisterResponse>

    suspend fun login(bodyLogin: BodyLogin): Response<UserLoginResponse>

    suspend fun verifyRegister(bodyVerifyOTP: BodyVerifyOTP): Response<Message>

    suspend fun sendOTPByMail(emailBody: EmailBody): Response<Message>
}