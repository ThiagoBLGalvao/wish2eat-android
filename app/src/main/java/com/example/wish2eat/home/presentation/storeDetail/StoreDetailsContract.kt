package com.example.wish2eat.home.presentation.storeDetail

import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface StoreDetailsContract {
    interface View{
        fun bindList(productList: List<ProductModel>)

        fun hideList()

        fun showList()

        fun showToast(messageId: Int)

        fun showToast(message: String)
    }

    interface Presenter: NetworkPresenterUtils{
        fun init()

        fun onFavClicked(model: ProductModel)
    }
}