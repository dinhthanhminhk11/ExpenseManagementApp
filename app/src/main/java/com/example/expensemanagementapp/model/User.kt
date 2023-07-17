package com.example.expensemanagementapp.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("tokenDevice") var tokenDevice: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("verified") var verified: Boolean? = null
)