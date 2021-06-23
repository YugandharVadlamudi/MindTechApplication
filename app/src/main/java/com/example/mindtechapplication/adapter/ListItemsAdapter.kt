package com.example.mindtechapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechapplication.R
import kotlinx.android.synthetic.main.inflate_rv_item.view.*

class ListItemsAdapter(val context: Context,val listItems:ArrayList<String>):RecyclerView.Adapter<ListItemsAdapter.ListItem>() {
    class ListItem(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItem {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.inflate_rv_item, parent, false)
        return ListItem(inflate)
    }

    override fun onBindViewHolder(holder: ListItem, position: Int) {
        holder.itemView.tv_item.text=listItems[position]
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}