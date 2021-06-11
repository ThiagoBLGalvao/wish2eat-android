package com.example.wish2eat.home.presentation.storeDetail

import android.view.View
import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.core.vo.FavoriteProduct
import com.example.wish2eat.common.core.vo.FavoriteStore
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.recycler_view_list_products.view.*

class StoreDetailsPresenter(
    val view: StoreDetailsContract.View?,
    val repository: WebRepositoryContract,
    private val dispose: CompositeDisposable = CompositeDisposable()
) : StoreDetailsContract.Presenter {

    lateinit var store: StoreModel

    lateinit var user: UserModel

    override fun init(userModel: UserModel, storeModel: StoreModel) {
        store = storeModel

        request(repository.getUser(userModel.id)) { view?.showToast(it) }
            .doOnNext {
                user = it

                store.productsList?.let { list ->
                    view?.apply {
                        showList()
                        bindList(list, user)
                    }
                }
            }
            .subscribe({}, {}).also { dispose.addAll(it) }
    }

    override fun onFavClicked(model: ProductModel, itemView: View) {
        if (!verifyStoreInUser(user, store)) {
            updateUser(store)

            request(repository.createFavStore(FavoriteStore(store.id, user.id))) { view?.showToast(it) }
                .subscribe({}, {}).also { dispose.addAll(it) }
        }

        if (!verifyProductInUser(user, model)) {

            updateUser(newProduct = model)

            request(repository.createFavProduct(FavoriteProduct(model.id, user.id))) { view?.showToast(it) }
                .doOnNext {
                    view?.showToast(it)
                }
                .doOnTerminate { itemView.favProductButton.setImageResource(R.drawable.ic_favorite_full) }
                .subscribe({}, {}).also { dispose.addAll(it) }
        }
    }

    private fun updateUser(newStore: StoreModel? = null, newProduct: ProductModel? = null){
        newStore?.let{ user.favoriteRestaurant?.add(it) }
        newProduct?.let { user.favoriteFoods?.add(it) }
    }

    private fun verifyProductInUser(userModel: UserModel, productModel: ProductModel) =
        userModel.favoriteFoods?.contains(productModel) == true

    private fun verifyStoreInUser(userModel: UserModel, storeModel: StoreModel) =
        userModel.favoriteRestaurant?.contains(storeModel) == true
}