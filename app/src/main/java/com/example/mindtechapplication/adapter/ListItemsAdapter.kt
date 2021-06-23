package com.example.mindtechapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechapplication.R

import kotlinx.android.synthetic.main.inflate_rv_item.view.*

class ListItemsAdapter(private val context: Context,private var listItems:ArrayList<String>):RecyclerView.Adapter<ListItemsAdapter.ListItem>(),Filterable {
    class ListItem(itemView: View) : RecyclerView.ViewHolder(itemView)
private var filteredList=listItems
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItem {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.inflate_rv_item, parent, false)
        return ListItem(inflate)
    }

    override fun onBindViewHolder(holder: ListItem, position: Int) {
        holder.itemView.tv_item.text=filteredList[position]
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredList = listItems
                } else {
                    filteredList = ArrayList()
                    val searchResults = listItems.filter { filterValue->filterValue.contains(charSearch,true)}
                    filteredList.addAll(searchResults)
                }

                return filterResults.also {
                    it.values = filteredList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as ArrayList<String>
                notifyDataSetChanged()

            }
        }
    }
}