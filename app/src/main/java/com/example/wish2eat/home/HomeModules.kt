package com.example.wish2eat.home

import com.example.wish2eat.home.presentation.account.ProfileContract
import com.example.wish2eat.home.presentation.account.ProfilePresenter
import com.example.wish2eat.home.presentation.dashboard.DashboardContract
import com.example.wish2eat.home.presentation.dashboard.DashboardPresenter
import com.example.wish2eat.home.presentation.productDetail.ProductDetailsContract
import com.example.wish2eat.home.presentation.productDetail.ProductsDetailsPresenter
import com.example.wish2eat.home.presentation.searchStore.SearchStoreContract
import com.example.wish2eat.home.presentation.searchStore.SearchStorePresenter
import com.example.wish2eat.home.presentation.storeDetail.StoreDetailsContract
import com.example.wish2eat.home.presentation.storeDetail.StoreDetailsPresenter
import org.koin.dsl.module

object HomeModules {
    val instance = module {
        factory<DashboardContract.Presenter> { (view: DashboardContract.View) -> DashboardPresenter(view = view, repository = get()) }

        factory<ProfileContract.Presenter> { (view: ProfileContract.View) -> ProfilePresenter(view = view, repository = get()) }

        factory<SearchStoreContract.Presenter> { (view: SearchStoreContract.View) -> SearchStorePresenter(view = view, repository = get()) }

        factory<StoreDetailsContract.Presenter> { (view: StoreDetailsContract.View) -> StoreDetailsPresenter(view = view, repository = get()) }

        factory<ProductDetailsContract.Presenter> { (view: ProductDetailsContract.View) -> ProductsDetailsPresenter(view = view, repository = get()) }
    }
}