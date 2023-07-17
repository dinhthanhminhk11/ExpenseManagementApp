package com.example.expensemanagementapp.model

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null
)