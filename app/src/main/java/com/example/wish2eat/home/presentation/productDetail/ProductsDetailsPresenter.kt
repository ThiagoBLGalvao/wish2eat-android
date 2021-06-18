package com.example.wish2eat.home.presentation.productDetail

import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.vo.FavoriteProduct
import com.example.wish2eat.common.core.vo.FavoriteStore
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class ProductsDetailsPresenter(
    private val view: ProductDetailsContract.View,
    private val repository: WebRepositoryContract,
    private val disposable: CompositeDisposable = CompositeDisposable()
) : ProductDetailsContract.Presenter {
    private lateinit var user: UserModel
    private lateinit var productEntity: ProductModel
    private lateinit var storeEntity: StoreModel

    override fun init(productModel: ProductModel, userModel: UserModel) {
        productEntity = productModel

        view.showLoader()

        view.bindProductDetails(productModel)

        getStore(productModel.storeID)

        getUser(userModel.id)
    }

    override fun onFavButtonClicked() {
        if (!verifyStoreInUser(user, storeEntity)) {
            updateUser(storeEntity)

            request(repository.createFavStore(FavoriteStore(storeEntity.id, user.id))) { view.showToast(it) }
                .subscribe({}, {}).also { disposable.addAll(it) }
        }
        if (!verifyProductInUser(user, productEntity)) {
            updateUser(newProduct = productEntity)
            favProduct()
            view.changeFavIcon(true)
        } else {
            removeProductFromUser(productEntity)
            favProduct()
            view.changeFavIcon(false)
        }
    }

    private fun getStore(storeId: Long) {
        request(repository.getStore(storeId)) { view.showToast(it) }
            .subscribe(
                { store ->
                    storeEntity = store
                    view.bindStoreCard(store)
                },
                {},
                { view.hideLoader() }
            ).also { disposable.addAll(it) }
    }

    private fun getUser(userId: Long) {
        request(repository.getUser(userId)) { view.showToast(it) }
            .subscribe(
                {model->
                    user = model
                    user.favoriteFoods?.let { bindButton(it) }
                },
                {},
                { view.hideLoader() }
            ).also { disposable.addAll(it) }
    }

    private fun bindButton(list: MutableList<ProductModel>) {
        list.forEach { product ->
            if (product.id == productEntity.id) {
                view.changeFavIcon(true)
            }
        }
    }

    private fun updateUser(newStore: StoreModel? = null, newProduct: ProductModel? = null) {
        newStore?.let { user.favoriteRestaurant?.add(it) }
        newProduct?.let { user.favoriteFoods?.add(it) }
    }

    private fun removeProductFromUser(productModel: ProductModel) {
        user.favoriteFoods?.remove(productModel)
    }

    private fun verifyProductInUser(userModel: UserModel, productModel: ProductModel) =
        userModel.favoriteFoods?.contains(productModel) == true

    private fun verifyStoreInUser(userModel: UserModel, storeModel: StoreModel): Boolean {
        userModel.favoriteRestaurant?.map {
            if (it.id == storeModel.id)
                return true
        }
        return false
    }

    private fun favProduct(){
        request(repository.createFavProduct( FavoriteProduct(productEntity.id, user.id))){ view.showToast(it) }
            .subscribe({},{}).also { disposable.addAll(it) }
    }
}