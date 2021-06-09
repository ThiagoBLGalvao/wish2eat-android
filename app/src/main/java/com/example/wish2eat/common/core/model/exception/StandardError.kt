package com.example.wish2eat.common.core.model.exception

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StandardError(
    val status: Int,
    val error: String,
    val message: String
):Parcelable