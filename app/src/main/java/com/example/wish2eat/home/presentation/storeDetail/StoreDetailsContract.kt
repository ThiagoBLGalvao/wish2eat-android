package com.example.wish2eat.home.presentation.storeDetail

import com.example.wish2eat.common.core.enum.StoreType
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface StoreDetailsContract {
    interface View{
        fun bindList(productList: List<ProductModel>, userModel: UserModel)

        fun bindStoreTitle(storeTitle: String)

        fun bindStoreType(storeType: StoreType)

        fun hideList()

        fun showList()

        fun showToast(messageId: Int)

        fun showToast(message: String)
    }

    interface Presenter: NetworkPresenterUtils{
        fun init(userModel: UserModel, storeModel: StoreModel)

        fun onFavClicked(model: ProductModel, itemView: android.view.View)
    }
}