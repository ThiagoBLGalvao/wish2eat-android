package com.example.wish2eat.home.presentation.productDetail

import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class ProductsDetailsPresenter(
    private val view: ProductDetailsContract.View,
    private val repository: WebRepositoryContract,
    private val disposable: CompositeDisposable = CompositeDisposable()
): ProductDetailsContract.Presenter {
    override fun init(productModel: ProductModel) {
        view.showLoader()

        view.bindProductDetails(productModel)
        request(repository.getStore(productModel.storeID)){ view.showToast(it) }
            .subscribe(
                { store -> view.bindStoreCard(store)},
                {},
                { view.hideLoader() }
            ).also { disposable.addAll(it) }
    }
}