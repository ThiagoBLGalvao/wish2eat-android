package com.example.wish2eat.home

import com.example.wish2eat.home.presentation.dashboard.DashboardContract
import com.example.wish2eat.home.presentation.dashboard.DashboardPresenter
import com.example.wish2eat.home.presentation.searchStore.SearchStoreContract
import com.example.wish2eat.home.presentation.searchStore.SearchStorePresenter
import org.koin.dsl.module

object HomeModules {
    val instance = module {
        factory<DashboardContract.Presenter> { (view: DashboardContract.View) -> DashboardPresenter(view = view, repository = get()) }

        factory<SearchStoreContract.Presenter> { (view: SearchStoreContract.View) -> SearchStorePresenter(view = view, repository = get()) }
    }
}