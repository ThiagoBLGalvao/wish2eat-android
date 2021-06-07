package com.example.wish2eat.common.core.model

import com.example.wish2eat.common.core.enum.StoreType

data class UserModel(
    val id: Long = 0,
    val name: String,
    val email: String,
    val password: String = "",
    val profilePhoto: Long = 0L,
    val favoriteFoods: List<ProductModel>? = null,
    val favoriteRestaurant: List<StoreModel>? = null
)

data class StoreModel(
    val id: Long,
    val storeType: StoreType,
    val name: String,
    val cep: String,
    val number:String,
    val productsList: List<ProductModel>
)

data class ProductModel(
    val id: Long,
    val name: String,
    val storeId: Long,
    val description: String,
    val value: Long
)