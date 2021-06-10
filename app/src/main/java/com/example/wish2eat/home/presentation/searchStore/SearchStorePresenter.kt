package com.example.wish2eat.home.presentation.searchStore

import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class SearchStorePresenter(
    private val view: SearchStoreContract.View?,
    private val repository: WebRepositoryContract,
    private val dispose: CompositeDisposable = CompositeDisposable()
) : SearchStoreContract.Presenter {

    private var listStoreModel: List<StoreModel>? = null

    override fun init() {
        view?.showLoader()

        view?.initList()

        request(repository.getAllStores()){ view?.showToast(it) }
            .doOnNext {
                processList(it)
            }
            .doOnTerminate { view?.hideLoader() }
            .subscribe({},{}).also { dispose.addAll(it) }
    }

    override fun onFilterStoreList() {
        TODO("Not yet implemented")
    }

    override fun onItemPressed(storeId: Long) {
        listStoreModel?.map {
            if (it.id == storeId)
                view?.openStoreDetails(it)
        }
    }

    private fun processList(list: List<StoreModel>?){
        if (!list.isNullOrEmpty()){
            listStoreModel = list

            view?.apply {
                showList()

                mountList(list)
            }
        }
    }
}