package com.example.mindtechapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechapplication.R
import kotlinx.android.synthetic.main.inflate_image_curso.view.*

class CursolAapter(val context: Context, val arrayResources: ArrayList<Int>) :
    RecyclerView.Adapter<CursolAapter.ImageViewHolder>() {
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.inflate_image_curso, parent, false)
        return ImageViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.itemView.imageView.setImageResource(arrayResources[position])
    }

    override fun getItemCount(): Int {
        return arrayResources.size
    }
}