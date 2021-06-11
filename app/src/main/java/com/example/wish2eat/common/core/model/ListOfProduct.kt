package com.example.wish2eat.common.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListOfProduct(
    val productLis: List<ProductModel>
): Parcelable