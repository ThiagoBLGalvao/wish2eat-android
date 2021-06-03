package com.example.wish2eat.account.presentaion.login

import com.example.wish2eat.R
import com.example.wish2eat.common.core.localApi.LocalRepositoryAccountContract
import com.example.wish2eat.common.core.model.LoginModel
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class LoginPresenter(
    private val view: LoginContract.View?,
    private val repository: WebRepositoryContract,
    private val dispose: CompositeDisposable = CompositeDisposable()
) : LoginContract.Presenter {

    override fun onLoginPressed(email: String, password: String) {
         request(repository.login(LoginModel(email, password)), callback = { view?.showToast(R.string.invalid_login) })
             .doOnNext { view?.openDashboard() }
             .subscribe().also { dispose.addAll(it) }
    }

    override fun onCreateAccountPressed() {
        view?.openRegisterFragment()
    }
}