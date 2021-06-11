package com.example.wish2eat.common.core.vo

import com.google.gson.annotations.SerializedName

data class FavoriteProduct(
    @SerializedName("product")
    val productId: Long,
    @SerializedName("user")
    val userId: Long
)

data class FavoriteStore(
    @SerializedName("store")
    val storeId: Long,
    @SerializedName("user")
    val userId: Long
)