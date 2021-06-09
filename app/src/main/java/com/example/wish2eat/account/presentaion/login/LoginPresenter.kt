package com.example.wish2eat.account.presentaion.login

import com.example.wish2eat.common.core.model.LoginModel
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class  LoginPresenter(
    private val view: LoginContract.View?,
    private val repository: WebRepositoryContract,
    private val dispose: CompositeDisposable = CompositeDisposable()
) : LoginContract.Presenter {

    override fun onLoginPressed(email: String, password: String) {
         request(repository.login(LoginModel(password, email)), callback = { text -> view?.showToast(text) })
             .doOnNext {
                 view?.openDashboard(it) }
             .subscribe({},{}).also { dispose.addAll(it) }
    }

    override fun onCreateAccountPressed() {
        view?.openRegisterFragment()
    }
}