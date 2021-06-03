package com.example.wish2eat.common.core.vo

data class FavoriteProduct(
    val userId: Long,
    val productId: Long
)

data class FavoriteStore(
    val userId: Long,
    val storeId: Long
)