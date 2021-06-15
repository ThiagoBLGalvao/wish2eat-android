package com.example.wish2eat.common.core.model

import android.os.Parcelable
import com.example.wish2eat.common.core.enum.StoreType
import com.example.wish2eat.common.core.vo.UserVO
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    val id: Long = 0,
    val name: String,
    val email: String,
    val password: String = "",
    val profilePhoto: Long = 0L,
    val favoriteFoods: MutableList<ProductModel>? = null,
    val favoriteRestaurant: MutableList<StoreModel>? = null
):Parcelable

fun UserModel.toVO() = UserVO(name = name, email = email, password = password)

@Parcelize
data class StoreModel(
    val id: Long,
    val storeType: StoreType,
    val name: String,
    val cep: String,
    val number:String,
    val productsList: List<ProductModel>? = null
): Parcelable

@Parcelize
data class ProductModel(
    val id: Long,
    val name: String,
    val storeID: Long,
    val description: String,
    val value: Double
):Parcelable