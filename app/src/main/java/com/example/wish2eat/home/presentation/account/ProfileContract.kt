package com.example.wish2eat.home.presentation.account

import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface ProfileContract {
    interface View{
        fun bind(user: UserModel)

        fun showToast(messageId: Int)

        fun showToast(message: String)

        fun showLoader()

        fun hideLoader()
    }

    interface Presenter: NetworkPresenterUtils{
        fun init(id: Long)

        fun onEditButtonClicked(userModel: UserModel)
    }
}