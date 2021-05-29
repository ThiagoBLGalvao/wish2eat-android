package com.example.wish2eat.splashScreen

import com.example.wish2eat.common.core.localApi.LocalRepositoryAccountContract

class SplashPresenter(
    private val view: SplashContract.View,
    private val repository: LocalRepositoryAccountContract
) : SplashContract.Presenter {
    override fun verifyLoginState() {
        if (repository.verifyLoginState())
            view.openHomeActivity()
        else view.openAccountActivity()
    }
}