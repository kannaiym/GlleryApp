package com.example.glleryapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.glleryapp.R
import com.example.glleryapp.data.model.ImageModel
import com.example.glleryapp.utils.DiffUtilsImages
import com.example.glleryapp.utils.setCornerRadius
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_rv.view.*

class ImageAdapter: ListAdapter<ImageModel, NewsViewHolder>(DiffUtilsImages.diffUtilImages) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ImageModel) {

        Picasso.get()
            .load(item?.image)
            .placeholder(R.drawable.aes)
            .error(R.drawable.aes)
            .into(itemView.ivImage)

        val radius = 8f
        itemView.ivImage.setCornerRadius(
            topLeft = radius,
            topRight = radius,
            bottomLeft = radius,
            bottomRight = radius
        )
    }
}