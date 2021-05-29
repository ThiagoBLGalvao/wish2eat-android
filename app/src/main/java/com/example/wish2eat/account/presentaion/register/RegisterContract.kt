package com.example.wish2eat.account.presentaion.register

import com.example.wish2eat.common.core.model.UserModel

interface RegisterContract {
    interface View{
        fun showToast(messageId: Int)

        fun showToast(message: String)
    }

    interface Presenter{
        fun onRegisterAccountButtonClicked(user: UserModel)
    }
}