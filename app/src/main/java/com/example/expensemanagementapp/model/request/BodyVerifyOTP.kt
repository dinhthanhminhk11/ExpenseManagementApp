package com.example.expensemanagementapp.model.request

import com.google.gson.annotations.SerializedName

data class BodyVerifyOTP(
    @SerializedName("email") var email: String? = null,
    @SerializedName("OTP") var OTP: String? = null

)