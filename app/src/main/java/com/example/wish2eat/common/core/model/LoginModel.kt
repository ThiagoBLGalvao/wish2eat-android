package com.example.wish2eat.common.core.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("password")
    val userPassword: String,
    @SerializedName("username")
    val userEmail: String
)