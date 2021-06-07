package com.example.wish2eat.home.presentation.dashboard

import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface DashboardContract {
    interface View{
        fun init()

        fun showToast(messageId: Int)

        fun showToast(message: String)

        fun showLoader()

        fun hideLoader()
    }

    interface Presenter: NetworkPresenterUtils{
        fun loadUser()
    }
}