package com.example.wish2eat.home.presentation.dashboard

import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.common.adapter.StoreListAdapter
import com.example.wish2eat.home.presentation.searchStore.SearchStoreFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DashboardFragment : BaseFragment(), DashboardContract.View {
    override val layoutResource: Int = R.layout.fragment_dashboard
    private val presenter: DashboardContract.Presenter by inject { parametersOf(this) }

    companion object{
        const val USER_MODEL = "user_model"

        fun newInstance(userModel: UserModel) = DashboardFragment().apply {
            arguments = bundleOf(
                USER_MODEL to userModel
            )
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.init(getUser())
    }

    override fun initFragment(rootView: View) {
        presenter.init(getUser())
    }

    override fun init() {
        rclFavStoreList.layoutManager = LinearLayoutManager(requireContext())

        bindButton()
        hideBasicToolbarBackButton()
    }

    override fun openProductList(favProductsList: List<ProductModel>) {
        showToast("${favProductsList[1]}")
    }

    override fun openAddNewProductFlow() {
        val fragment = SearchStoreFragment.newInstance()

        targetingManager.replace(fragment, "search_store_list")
    }

    override fun bindList(favStores: List<StoreModel>) {
        val storeAdapter = StoreListAdapter(favStores){ presenter.onCardClicked(it) }

        rclFavStoreList?.adapter = storeAdapter
    }

    override fun bindButton() {
        customBottomButton?.apply {
            bindText(getString(R.string.add_product))
            bindImage(R.drawable.ic_plus)
            setOnClickListener { presenter.onButtonClicked() }
        }
    }

    override fun showCard() {
        emptyListCard?.visibility = View.VISIBLE
    }

    override fun hideCard() {
        emptyListCard?.visibility = View.GONE
    }

    override fun showList() {
        rclFavStoreList?.visibility = View.VISIBLE
    }

    override fun hideList() {
        rclFavStoreList?.visibility = View.GONE
    }

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoader() {
        basicLoader.changeVisibility(true)
    }

    override fun hideLoader() {
        basicLoader.changeVisibility(false)
    }

    private fun getUser() = arguments?.getParcelable<UserModel>(USER_MODEL)!!
}