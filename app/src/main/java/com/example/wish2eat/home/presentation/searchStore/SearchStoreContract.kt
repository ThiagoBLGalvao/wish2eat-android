package com.example.wish2eat.home.presentation.searchStore

import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface SearchStoreContract {
    interface View{
        fun openStoreDetails(storeModel: StoreModel)

        fun mountList(list: List<StoreModel>)

        fun initList()

        fun showList()

        fun hideList()

        fun showLoader()

        fun hideLoader()

        fun showToast(messageInt: Int)

        fun showToast(message: String)
    }
    interface Presenter: NetworkPresenterUtils{
        fun init()

        fun onFilterStoreList()

        fun onItemPressed(storeId: Long)
    }
}