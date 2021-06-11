package com.example.wish2eat.home.presentation.dashboard

import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class DashboardPresenter(
    val view: DashboardContract.View?,
    val repository: WebRepositoryContract,
    val dispose: CompositeDisposable = CompositeDisposable()
):DashboardContract.Presenter {
    var userModel: UserModel? = null

    override fun init(model: UserModel) {
        request(repository.getUser(model.id)){ view?.showToast(it) }
            .doOnNext {
                userModel = it

                if(userModel?.favoriteRestaurant.isNullOrEmpty())
                    view?.showCard()
                else{
                    userModel?.favoriteRestaurant?.let{ view?.bindList(it) }
                    view?.showList()
                }
            }
            .subscribe({},{}).also { dispose.addAll(it) }

        view?.init()
    }

    override fun onCardClicked(storeId: Long) {
        userModel?.favoriteFoods?.filter { it.storeID == storeId }?.also { view?.openProductList(it) }
    }

    override fun onButtonClicked() {
        view?.openAddNewProductFlow()
    }
}