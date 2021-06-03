package com.example.wish2eat.common.core.vo

import android.os.Parcelable
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserVO(
    val id: Long = 0L,
    @SerializedName("nome")
    val name: String,
    val email: String,
    val password: String? = "",
    @SerializedName("addProducts")
    val favoriteProductsList: List<ProductVO>? = listOf(),
    @SerializedName("addStores")
    val favoriteStoreList: List<StoreVO>? = listOf()
) : Parcelable

fun UserVO.toModel() = UserModel(
    id,
    name,
    email,
    favoriteFoods = favoriteProductsList?.map { productVO -> productVO.toModel() },
    favoriteRestaurant = favoriteStoreList?.map { storeVo -> storeVo.toModel() }
)

@Parcelize
data class ProductVO(
    val id: Long,
    val description: String,
    val name: String,
    val storeId: Long,
    @SerializedName("value")
    val productValue: Long
) : Parcelable

fun ProductVO.toModel() = ProductModel(
    id,
    name,
    storeId,
    description,
    productValue
)

@Parcelize
data class ListOfStoresVO(
    val listStores: List<StoreVO>
): Parcelable

@Parcelize
data class StoreVO(
    val id: Long,
    val name: String,
    val cep: String,
    val number: String,
    val productsList: List<ProductVO>
) : Parcelable

fun StoreVO.toModel() = StoreModel(
    id,
    name,
    cep,
    number,
    productsList = productsList.map { productVO -> productVO.toModel() }
)