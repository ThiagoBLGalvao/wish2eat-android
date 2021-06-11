package com.example.wish2eat.home.presentation.searchStore

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.adapter.StoreListAdapter
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.home.presentation.storeDetail.StoreDetailsFragment
import kotlinx.android.synthetic.main.fragment_search_store.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchStoreFragment: BaseFragment(), SearchStoreContract.View {
    override val layoutResource: Int = R.layout.fragment_search_store

    private val presenter: SearchStoreContract.Presenter by inject { parametersOf(this) }

    companion object{
        fun newInstance() = SearchStoreFragment()
    }

    override fun initFragment(rootView: View) {
        showBasicToolbarBackButton()
        presenter.init()
    }

    override fun openStoreDetails(storeModel: StoreModel) {
        val fragment = StoreDetailsFragment.newInstance(storeModel)

        targetingManager.replace(fragment,"store_details_fragment")
    }

    override fun mountList(list: List<StoreModel>) {
        rclStoreList.adapter = StoreListAdapter(list){
            presenter.onItemPressed(it)
        }
    }

    override fun initList() {
        rclStoreList.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun showList() {
        rclStoreList.visibility = View.VISIBLE
    }

    override fun hideList() {
        rclStoreList.visibility = View.GONE
    }

    override fun showLoader() {
        basicLoader.changeVisibility(true)
    }

    override fun hideLoader() {
        basicLoader.changeVisibility(false)
    }

    override fun showToast(messageInt: Int) {
        showToast(getString(messageInt))
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}