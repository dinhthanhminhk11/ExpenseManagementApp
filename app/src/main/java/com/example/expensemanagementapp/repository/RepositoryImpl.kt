package com.example.expensemanagementapp.repository

import com.example.expensemanagementapp.constant.Resource
import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.request.BodyRegister
import com.example.expensemanagementapp.model.request.BodyVerifyOTP
import com.example.expensemanagementapp.model.request.EmailBody
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.model.response.UserRegisterResponse
import com.example.expensemanagementapp.repository.dataSource.ApiRequestRemoteDataSource
import retrofit2.Response

class RepositoryImpl(private val apiRequestRemoteDataSource: ApiRequestRemoteDataSource) :
    Repository {
    override suspend fun register(bodyRegister: BodyRegister): Resource<UserRegisterResponse> {
        return responseToResource(apiRequestRemoteDataSource.register(bodyRegister))
    }

    override suspend fun login(bodyLogin: BodyLogin): Resource<UserLoginResponse> =
        responseToResource(apiRequestRemoteDataSource.login(bodyLogin))

    override suspend fun verifyRegister(bodyVerifyOTP: BodyVerifyOTP): Resource<Message> =
        responseToResource(apiRequestRemoteDataSource.verifyRegister(bodyVerifyOTP))

    override suspend fun sendOTPByMail(emailBody: EmailBody): Resource<Message> =
        responseToResource(apiRequestRemoteDataSource.sendOTPByMail(emailBody))

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
}