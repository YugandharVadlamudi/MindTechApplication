package com.example.mindtechapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechapplication.R
import com.example.mindtechapplication.databinding.InflateRvItemBinding

// import kotlinx.android.synthetic.main.inflate_rv_item.view.*

class ListItemsAdapter(private val context: Context, private var listItems: ArrayList<String>) : RecyclerView.Adapter<ListItemsAdapter.ListItem>(), Filterable {
    inner class ListItem(val bindin: InflateRvItemBinding) : RecyclerView.ViewHolder(bindin.root)
    private var filteredList = listItems
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItem {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.inflate_rv_item, parent, false)
        val inflate1 = InflateRvItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListItem(inflate1)
    }

    override fun onBindViewHolder(holder: ListItem, position: Int) {
        Log.e("TAG", "onBindViewHolder: ${filteredList[position]}")
        holder.bindin.tvItem.text = filteredList[position]
    }

    override fun getItemCount(): Int {
        Log.e("TAG", "geItemCount: a${filteredList.size}")
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
                    val searchResults = listItems.filter { filterValue -> filterValue.contains(charSearch, true) }
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
