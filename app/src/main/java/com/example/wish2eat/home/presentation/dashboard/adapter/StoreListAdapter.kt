package com.example.wish2eat.home.presentation.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wish2eat.R
import com.example.wish2eat.common.core.model.StoreModel
import kotlinx.android.synthetic.main.recycler_view_list_item.view.*

class StoreListAdapter(
    private val storeList: List<StoreModel>,
    val clickListener: (storeId: Long) -> Unit
) :
    RecyclerView.Adapter<StoreListAdapter.StoreListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreListHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_item, parent, false)

        return StoreListHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoreListHolder, position: Int) {
        val item = storeList[position]

        holder.bind(item, clickListener)
    }

    override fun getItemCount() = storeList.size

    class StoreListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: StoreModel, clickListener: (storeId: Long) -> Unit) {
            itemView.apply {
                cardItemImageLogo.setImageResource(item.storeType.storeIcon)
                itemListText.text = item.name
                cardItem.setOnClickListener { clickListener(item.id) }
            }
        }
    }
}
