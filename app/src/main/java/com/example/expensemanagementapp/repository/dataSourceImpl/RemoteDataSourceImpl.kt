package com.example.expensemanagementapp.repository.dataSourceImpl

import com.example.expensemanagementapp.api.ApiRequest
import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.model.response.UserRegisterResponse
import com.example.expensemanagementapp.repository.dataSource.ApiRequestRemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(private val apiRequest: ApiRequest) : ApiRequestRemoteDataSource {
    override suspend fun register(bodyRegister: BodyRegister): Response<UserRegisterResponse> {
        return apiRequest.register(bodyRegister)
    }

    override suspend fun login(bodyLogin: BodyLogin): Response<UserLoginResponse> {
        return apiRequest.login(bodyLogin)
    }

    override suspend fun verifyRegister(bodyVerifyOTP: BodyVerifyOTP): Response<Message> {
        return apiRequest.verifyRegister(bodyVerifyOTP)
    }

    override suspend fun sendOTPByMail(emailBody: EmailBody): Response<Message> {
        return apiRequest.sendOTPByMail(emailBody)
    }
}