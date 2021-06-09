package com.example.wish2eat.account.presentaion.register

import com.example.wish2eat.common.core.vo.UserVO
import com.example.wish2eat.common.core.webApi.NetworkPresenterUtils

interface RegisterContract {
    interface View{
        fun showToast(messageId: Int)

        fun showToast(message: String)

        fun showLoader()

        fun hideLoader()
    }

    interface Presenter: NetworkPresenterUtils{
        fun onRegisterAccountButtonClicked(vo: UserVO)
    }
}