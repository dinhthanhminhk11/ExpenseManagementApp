package com.example.expensemanagementapp.model.response

import com.example.expensemanagementapp.model.Message
import com.example.expensemanagementapp.model.User
import com.google.gson.annotations.SerializedName

data class UserLoginResponse(
    @SerializedName("data") var data: User? = User(),
    @SerializedName("message") var message: Message? = Message()
)