package com.example.glleryapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.glleryapp.R
import com.example.glleryapp.common.BaseAdapter
import com.example.glleryapp.common.BaseViewHolder
import com.example.glleryapp.data.model.ImageModel


class ImageAdapter : BaseAdapter() {

    var photoArray = mutableListOf<ImageModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return photoArray.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        setupGalleryViewHolder(holder as GalleryViewHolder, position)
    }

    private fun setupGalleryViewHolder(holder: GalleryViewHolder, position: Int){
        val item = photoArray[position]
        holder.bind(item)
    }

    fun addItems(items: MutableList<ImageModel>) {
        photoArray = items
        notifyDataSetChanged()
    }

}

class GalleryViewHolder(itemView: View): BaseViewHolder(itemView){
    private val image: ImageView = itemView.findViewById(R.id.ivImage)
    fun bind(item: ImageModel){
        Glide
            .with(image.context)
            .load(item.image)
            .centerCrop()
            .into(image)
    }
}

//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.glleryapp.R
//import com.example.glleryapp.data.model.ImageModel
//import com.example.glleryapp.utils.DiffUtilsImages
//import com.example.glleryapp.utils.setCornerRadius
//import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.item_rv.view.*
//
//class ImageAdapter: ListAdapter<ImageModel, NewsViewHolder>(DiffUtilsImages.diffUtilImages) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
//        return NewsViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//}
//
//class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    fun bind(item: ImageModel) {
//
//        Picasso.get()
//            .load(item?.image)
//            .placeholder(R.drawable.aes)
//            .error(R.drawable.aes)
//            .into(itemView.ivImage)
//
//        val radius = 8f
//        itemView.ivImage.setCornerRadius(
//            topLeft = radius,
//            topRight = radius,
//            bottomLeft = radius,
//            bottomRight = radius
//        )
//    }
//}