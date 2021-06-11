package com.example.wish2eat.home.presentation.favProductsList

import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseFragment
import com.example.wish2eat.common.adapter.FavoriteProductsListAdapter
import com.example.wish2eat.common.core.model.ListOfProduct
import kotlinx.android.synthetic.main.fragment_favorites_products_list.*

class FavoritesProductsListFragment: BaseFragment(), FavoritesProductsListContract.View {
    override val layoutResource: Int = R.layout.fragment_favorites_products_list

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

    override fun bindList() {
        rclFavoriteProductList.adapter = FavoriteProductsListAdapter(getList().productLis)
    }

    private fun getList() = arguments?.getParcelable<ListOfProduct>(FAV_PROD_LIST)!!
}