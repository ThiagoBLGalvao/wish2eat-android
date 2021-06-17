package com.example.wish2eat.home.presentation.productDetail

import android.view.View
import androidx.core.os.bundleOf
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.StoreModel
import kotlinx.android.synthetic.main.fragment_products_details.*

class ProductDetailsFragment: BaseFragment(),ProductDetailsContract.View {
    override val layoutResource: Int = R.layout.fragment_products_details

    companion object{
        const val RECEIVED_PRODUCT = "received_product"

        fun newInstance(productModel: ProductModel) = ProductDetailsFragment().apply {
            arguments = bundleOf(
                RECEIVED_PRODUCT to productModel
            )
        }
    }

    private fun getProduct() = arguments?.getParcelable<ProductModel>(RECEIVED_PRODUCT)

    override fun initFragment(rootView: View) {
        bindButton()
    }

    fun bindButton(){
        shareButton?.bindText(getString(R.string.share))
        shareButton?.bindImage(R.drawable.ic_share)
    }

    override fun bindProductDetails(productModel: ProductModel) {
        productTitleName.text = productModel.name
        productValue.text = productModel.value.toString()
        productDescription.text = productModel.description
    }

    override fun bindStoreCard(storeModel: StoreModel) {
        storeTypeIcon.setImageResource(storeModel.storeType.storeIcon)
        cardStoreName.text = storeModel.name
    }

    override fun showToast(messageInt: Int) {
        TODO("Not yet implemented")
    }

    override fun showToast(message: String) {
        TODO("Not yet implemented")
    }

    override fun showLoader() {
        TODO("Not yet implemented")
    }

    override fun hideLoader() {
        TODO("Not yet implemented")
    }
}