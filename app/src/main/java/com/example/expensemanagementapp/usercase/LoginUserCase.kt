package com.example.expensemanagementapp.usercase

import com.example.expensemanagementapp.constant.Resource
import com.example.expensemanagementapp.model.request.BodyLogin
import com.example.expensemanagementapp.model.response.UserLoginResponse
import com.example.expensemanagementapp.repository.Repository

class LoginUserCase(private val repository: Repository) {
    suspend fun executeLogin(bodyLogin: BodyLogin): Resource<UserLoginResponse> {
        return repository.login(bodyLogin)
    }
}