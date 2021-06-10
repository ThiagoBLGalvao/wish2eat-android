package com.example.wish2eat.home.presentation.storeDetail

import android.view.View
import android.widget.Toast
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.core.model.ProductModel
import kotlinx.android.synthetic.main.fragment_store_details.*

class StoreDetailsFragment: BaseFragment(), StoreDetailsContract.View {
    override val layoutResource: Int = R.layout.fragment_store_details
    override fun initFragment(rootView: View) {
        TODO("Not yet implemented")
    }

    override fun bindList(productList: List<ProductModel>) {

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
}