package com.example.wish2eat.home.presentation.account

import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.model.toVO
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class ProfilePresenter(
    private val view: ProfileContract.View,
    private val repository: WebRepositoryContract,
    private val dispose: CompositeDisposable = CompositeDisposable()
    ) : ProfileContract.Presenter {

    private var userId: Long = 0L

    override fun init(id: Long) {
        userId = id

        view.showLoader()

        request(repository.getUser(id)){ view.showToast(it) }
            .doOnNext { view.bind(it) }
            .doOnTerminate { view.hideLoader() }
            .subscribe({},{}).also { dispose.addAll(it) }
    }

    override fun onEditButtonClicked(userModel: UserModel) {
        view.showLoader()

        request(repository.update(userId, userModel.toVO())){ view.showToast(it) }
            .doOnNext { view.showToast(R.string.updated_account) }
            .doOnTerminate { view.hideLoader() }
            .subscribe({}, {}).also { dispose.addAll(it) }
    }
}