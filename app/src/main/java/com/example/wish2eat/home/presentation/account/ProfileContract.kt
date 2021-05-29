package com.example.wish2eat.home.presentation.account

import com.example.wish2eat.common.core.model.UserModel

interface ProfileContract {
    interface View{
        fun bind(user: UserModel)

        fun changeButtonText()

        fun changeInputVisibility()

        fun showToast(messageId: Int)
    }

    interface Presenter{
        fun init(email: String)

        fun onEditButtonClicked()

        fun updateAccount(user: UserModel)
    }
}