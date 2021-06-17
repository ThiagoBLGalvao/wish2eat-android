package com.example.wish2eat.home.presentation.productDetail

import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface ProductDetailsContract {
    interface View{
        fun bindProductDetails(productModel: ProductModel)

        fun bindStoreCard(storeModel: StoreModel)

        fun showToast(messageInt: Int)

        fun showToast(message: String)

        fun showLoader()

        fun hideLoader()
    }

    interface Presenter: NetworkPresenterUtils{
        fun init(productModel: ProductModel)
    }
}