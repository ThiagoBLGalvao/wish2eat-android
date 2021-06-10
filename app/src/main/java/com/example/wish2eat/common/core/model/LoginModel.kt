package com.example.wish2eat.common.core.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginModel(
    @SerializedName("email")
    val username: String,
    @SerializedName("password")
    val password: String
):Parcelable