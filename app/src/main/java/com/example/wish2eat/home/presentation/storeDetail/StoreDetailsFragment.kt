package com.example.wish2eat.home.presentation.storeDetail

import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.adapter.StoreProductsAdapter
import com.example.wish2eat.common.core.enum.StoreType
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_store_details.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class StoreDetailsFragment : BaseFragment(), StoreDetailsContract.View {
    override val layoutResource: Int = R.layout.fragment_store_details

    val presenter: StoreDetailsContract.Presenter by inject { parametersOf(this) }

    companion object {
        const val SELECTED_STORE = "selected_store"

        fun newInstance(storeModel: StoreModel) = StoreDetailsFragment().apply {
            arguments = bundleOf(
                SELECTED_STORE to storeModel
            )
        }
    }

    override fun initFragment(rootView: View) {
        presenter.init(getEntity(), getStoreModel())
    }

    override fun bindList(productList: List<ProductModel>, userModel: UserModel) {
        rclStoreProductsList?.layoutManager = LinearLayoutManager(requireContext())

        rclStoreProductsList?.adapter =
            StoreProductsAdapter(productList, userModel) { productModel, view ->
                presenter.onFavClicked(
                    productModel, view
                )
            }
    }

    override fun bindStoreTitle(storeTitle: String) {
        storeNameLabel?.text = storeTitle
    }

    override fun bindStoreType(storeType: StoreType) {
        storeTypeLabel?.text = storeType.nameType
    }

    override fun hideList() {
        rclStoreProductsList?.visibility = View.GONE
    }

    override fun showList() {
        rclStoreProductsList?.visibility = View.VISIBLE
    }

    override fun showToast(messageId: Int) {
        showToast(getString(messageId))
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun getEntity() = (activity as HomeActivity).getEntity()

    private fun getStoreModel() = arguments?.getParcelable<StoreModel>(SELECTED_STORE)!!
}