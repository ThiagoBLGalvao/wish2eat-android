package com.example.wish2eat.account.presentaion.login

import com.example.wish2eat.R
import com.example.wish2eat.common.core.localApi.LocalRepositoryAccountContract

class LoginPresenter(
    private val view: LoginContract.View?,
    private val repository: LocalRepositoryAccountContract
) : LoginContract.Presenter {

    override fun onLoginPressed(email: String, password: String) {
        if (repository.login(email, password))
            view?.openDashboard()
        else view?.showToast(R.string.invalid_login)
    }

    override fun onCreateAccountPressed() {
        view?.openRegisterFragment()
    }
}