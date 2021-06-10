package com.example.wish2eat.common.core.model.exception

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StandardError(
    val status: Int,
    val error: String,
    val message: String,
    @SerializedName("errors")
    val errorValidation: Array<ErrorValidations>?
):Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StandardError

        if (status != other.status) return false
        if (error != other.error) return false
        if (message != other.message) return false
        if (errorValidation != null) {
            if (other.errorValidation == null) return false
            if (!errorValidation.contentEquals(other.errorValidation)) return false
        } else if (other.errorValidation != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = status
        result = 31 * result + error.hashCode()
        result = 31 * result + message.hashCode()
        result = 31 * result + (errorValidation?.contentHashCode() ?: 0)
        return result
    }
}

@Parcelize
data class ErrorValidations(
    val fieldName: String?,
    val message: String?
):Parcelable