package com.example.wish2eat.account.presentaion.login

interface LoginContract {
    interface View{
        fun openRegisterFragment()

        fun openDashboard()

        fun showToast(messageId: Int)
    }

    interface Presenter{
        fun onLoginPressed(email: String, password: String)

        fun onCreateAccountPressed()
    }
}