package com.example.wish2eat.common.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.ProductModel
import kotlinx.android.synthetic.main.recycler_view_favorite_products_list.view.*

class FavoriteProductsListAdapter(
    private val favProductsList: List<ProductModel>,
    private val listener: (productModel: ProductModel) -> Unit
) : RecyclerView.Adapter<FavoriteProductsListAdapter.FavoriteProductsListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteProductsListHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_favorite_products_list, parent, false)

        return FavoriteProductsListHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoriteProductsListHolder, position: Int) {
        val element = favProductsList[position]

        holder.bind(element,listener)
    }

    override fun getItemCount() = favProductsList.size

    class FavoriteProductsListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productModel: ProductModel, listener: (productModel: ProductModel) -> Unit) {
            itemView.apply {
                favProductNameLabel.text = productModel.name
                favProductPrice.text = String.format("%.2f", productModel.value)
                favProductCardItem.setOnClickListener { listener.invoke(productModel) }
            }
        }
    }
}