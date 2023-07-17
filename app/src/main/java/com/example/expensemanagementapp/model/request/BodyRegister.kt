package com.example.expensemanagementapp.model.request

import com.google.gson.annotations.SerializedName

data class BodyRegister(
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("tokenDevice") var tokenDevice: String? = null
)