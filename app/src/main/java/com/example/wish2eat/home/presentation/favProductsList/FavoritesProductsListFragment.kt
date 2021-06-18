package com.example.wish2eat.home.presentation.favProductsList

import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.adapter.FavoriteProductsListAdapter
import com.example.wish2eat.common.core.model.ListOfProduct
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.home.HomeActivity
import com.example.wish2eat.home.presentation.productDetail.ProductDetailsFragment
import kotlinx.android.synthetic.main.fragment_favorites_products_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FavoritesProductsListFragment: BaseFragment(), FavoritesProductsListContract.View {
    override val layoutResource: Int = R.layout.fragment_favorites_products_list

    private val presenter: FavoritesProductsListContract.Presenter by inject{ parametersOf(this) }

    companion object{
        const val FAV_PROD_LIST = "fav_list_prod"

        fun newInstance(listFavProduct: ListOfProduct) = FavoritesProductsListFragment().apply {
            arguments = bundleOf(
                FAV_PROD_LIST to listFavProduct
            )
        }
    }

    override fun initFragment(rootView: View) {
        rclFavoriteProductList.layoutManager = LinearLayoutManager(requireContext())
        bindList()
    }

    override fun onResume() {
        super.onResume()
        presenter.updateList(getEntity().id)
    }

    private fun openProductsDetails(productModel: ProductModel){
        val fragment = ProductDetailsFragment.newInstance(productModel)

        targetingManager.replace(fragment, "product_details_fragment")
    }

    override fun bindList(list: MutableList<ProductModel>?) {
        if(list.isNullOrEmpty()){
            rclFavoriteProductList.adapter = FavoriteProductsListAdapter(getList().productLis){
                openProductsDetails(it)
            }
        }else{
            rclFavoriteProductList.adapter = FavoriteProductsListAdapter(list){
                openProductsDetails(it)
            }
        }
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

    private fun getList() = arguments?.getParcelable<ListOfProduct>(FAV_PROD_LIST)!!

    private fun getEntity() = (activity as HomeActivity).getEntity()
}