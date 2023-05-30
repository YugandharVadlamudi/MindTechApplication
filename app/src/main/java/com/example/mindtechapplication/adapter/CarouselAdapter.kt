package com.example.mindtechapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechapplication.databinding.InflateImageCursoBinding

// import kotlinx.android.synthetic.main.inflate_image_curso.view.*

class CarouselAdapter(private val context: Context, private val arrayResources: ArrayList<Int>) :
    RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: InflateImageCursoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = InflateImageCursoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageView.setImageResource(arrayResources[position])
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return arrayResources.size
    }
}
