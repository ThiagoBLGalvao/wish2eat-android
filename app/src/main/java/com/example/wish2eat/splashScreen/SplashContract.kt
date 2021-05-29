package com.example.wish2eat.splashScreen

interface SplashContract {
    interface View{
        fun openAccountActivity()

        fun openHomeActivity()
    }

    interface Presenter{
        fun verifyLoginState()
    }
}