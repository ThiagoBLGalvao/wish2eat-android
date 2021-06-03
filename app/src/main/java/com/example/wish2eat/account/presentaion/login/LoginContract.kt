package com.example.wish2eat.account.presentaion.login

import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface LoginContract {
    interface View{
        fun openRegisterFragment()

        fun openDashboard()

        fun showToast(messageId: Int)

        fun showToast(message: String)
    }

    interface Presenter: NetworkPresenterUtils{
        fun onLoginPressed(email: String, password: String)

        fun onCreateAccountPressed()
    }
}