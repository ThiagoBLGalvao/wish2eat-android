package com.example.wish2eat.common.core.vo

import android.os.Parcelable
import com.example.wish2eat.common.core.enum.StoreType
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
    @SerializedName("addedProducts")
    val favoriteProductsList: MutableList<ProductVO>? = mutableListOf(),
    @SerializedName("addStores")
    val favoriteStoreList: MutableList<StoreVO>? = mutableListOf()
) : Parcelable

fun UserVO.toModel() = UserModel(
    id,
    name,
    email,
    favoriteFoods = favoriteProductsList?.map { productVO -> productVO.toModel() } as MutableList<ProductModel>?,
    favoriteRestaurant = favoriteStoreList?.map { storeVo -> storeVo.toModel() } as MutableList<StoreModel>?
)

@Parcelize
data class ProductVO(
    val id: Long,
    val description: String,
    val name: String,
    val storeID: Long,
    @SerializedName("value")
    val productValue: Double
) : Parcelable

fun ProductVO.toModel() = ProductModel(
    id,
    name,
    storeID,
    description,
    productValue
)

@Parcelize
data class StoreVO(
    val id: Long,
    val name: String,
    @SerializedName("type")
    val storeType: Int,
    val cep: String,
    val number: String,
    @SerializedName("products")
    val productsList: Array<ProductVO>?
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StoreVO

        if (id != other.id) return false
        if (name != other.name) return false
        if (storeType != other.storeType) return false
        if (cep != other.cep) return false
        if (number != other.number) return false
        if (productsList != null) {
            if (other.productsList == null) return false
            if (!productsList.contentEquals(other.productsList)) return false
        } else if (other.productsList != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + storeType
        result = 31 * result + cep.hashCode()
        result = 31 * result + number.hashCode()
        result = 31 * result + (productsList?.contentHashCode() ?: 0)
        return result
    }
}

fun StoreVO.toModel() = StoreModel(
    id,
    StoreType.from(storeType),
    name,
    cep,
    number,
    productsList = productsList?.map { it.toModel() }
)