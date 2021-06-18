package com.example.wish2eat.home.presentation.favProductsList

import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class FavoritesProductsListPresenter(
    private val view: FavoritesProductsListContract.View,
    private val repository: WebRepositoryContract,
    private val disposable: CompositeDisposable = CompositeDisposable()
): FavoritesProductsListContract.Presenter {
    override fun updateList(userId: Long) {
        view.showLoader()
        request( repository.getUser(userId) ){ view.showToast(it) }
            .subscribe(
                { it.favoriteFoods?.let { view.bindList(it) } },
                {},
                { view.hideLoader() }
            ).also { disposable.addAll(it) }
    }
}