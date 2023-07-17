package com.example.expensemanagementapp.model.request

import com.google.gson.annotations.SerializedName

data class BodyLogin(
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null
)