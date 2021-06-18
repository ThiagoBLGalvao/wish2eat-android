package com.example.wish2eat.home.presentation.favProductsList

import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface FavoritesProductsListContract {
    interface View {
        fun bindList()

        fun updateList(list: MutableList<ProductModel>?)

        fun showToast(messageInt: Int)

        fun showToast(message: String)

        fun showLoader()

        fun hideLoader()
    }

    interface Presenter : NetworkPresenterUtils {
        fun updateList(userId: Long)
    }
}