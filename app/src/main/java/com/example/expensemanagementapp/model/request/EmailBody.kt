package com.example.expensemanagementapp.model.request

import com.google.gson.annotations.SerializedName

data class EmailBody(@SerializedName("email") var email: String? = null)