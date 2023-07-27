package com.example.expensemanagementapp.api

import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.model.response.UserRegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRequest {
    @POST("auth/register")
    suspend fun register(@Body bodyRegister: BodyRegister): Response<UserRegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body bodyLogin: BodyLogin): Response<UserLoginResponse>

    @POST("auth/verifyRegister")
    suspend fun verifyRegister(@Body bodyVerifyOTP: BodyVerifyOTP): Response<Message>

    @POST("auth/generate-otp")
    suspend fun sendOTPByMail(@Body emailBody: EmailBody): Response<Message>
}