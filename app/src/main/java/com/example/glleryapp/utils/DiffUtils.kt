package com.example.glleryapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.glleryapp.data.model.ImageModel

object DiffUtilsImages {

    val diffUtilImages = object : DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem == newItem
        }
    }
}
