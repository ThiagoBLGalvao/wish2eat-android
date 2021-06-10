//package com.example.wish2eat.common.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.wish2eat.R
//import com.example.wish2eat.common.core.model.ProductModel
//import java.util.zip.Inflater
//
//class StoreProductsAdapter(
//    val productList: List<ProductModel>,
//    val listener: (model: ProductModel) -> Unit
//): RecyclerView.Adapter<StoreProductsAdapter.StoreProductsHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreProductsHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_list_products, parent, false)
//    }
//
//    override fun onBindViewHolder(holder: StoreProductsHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount() = productList.size
//
//    class StoreProductsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//
//    }
//}
