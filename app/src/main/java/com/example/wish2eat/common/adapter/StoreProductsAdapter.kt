package com.example.wish2eat.common.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.ProductModel
import com.example.wish2eat.common.core.model.UserModel
import kotlinx.android.synthetic.main.recycler_view_list_products.view.*

class StoreProductsAdapter(
    private val productList: List<ProductModel>,
    private val userModel: UserModel,
    val listener: (model: ProductModel, itemView:View) -> Unit
) : RecyclerView.Adapter<StoreProductsAdapter.StoreProductsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreProductsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_products, parent, false)

        return StoreProductsHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoreProductsHolder, position: Int) {
        val model = productList[position]

        holder.bind(model, userModel, listener)
    }

    override fun getItemCount() = productList.size

    class StoreProductsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            model: ProductModel, userModel: UserModel,
            listener: (model: ProductModel, itemView:View) -> Unit
        ) {
            itemView.apply {
                productNameLabel?.text = model.name

                productPriceLabel.text = model.value.toString()

                favProductButton?.apply {

                    userModel.favoriteFoods?.map {
                        if (it.id == model.id) setImageResource(
                            R.drawable.ic_favorite_full
                        )
                    }

                    setOnClickListener { listener.invoke(model, itemView) }
                }
            }
        }
    }
}
