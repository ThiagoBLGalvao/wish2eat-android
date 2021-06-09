package com.example.wish2eat.home.presentation.dashboard

import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface DashboardContract {
    interface View{
        fun init()

        fun openProductList(favProductsList: List<ProductModel>)

        fun openAddNewProductFlow()

        fun bindList(favStores:List<StoreModel>)

        fun bindButton()

        fun showCard()

        fun hideCard()

        fun showList()

        fun hideList()

        fun showToast(messageId: Int)

        fun showToast(message: String)

        fun showLoader()

        fun hideLoader()
    }

    interface Presenter: NetworkPresenterUtils{
        fun init(model: UserModel)

        fun onCardClicked(storeId: Long)

        fun onButtonClicked()
    }
}