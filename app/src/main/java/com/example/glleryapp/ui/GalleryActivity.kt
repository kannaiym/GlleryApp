package com.example.glleryapp.ui

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import com.example.glleryapp.R
import com.example.glleryapp.data.model.ImageModel
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_gallery.view.*

class GalleryActivity : AppCompatActivity() {

    private val imageAdapter by lazy {
        ImageAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        setupToolbar()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerViewImages.adapter = imageAdapter
        recyclerViewImages.layoutManager = GridLayoutManager(this, 3)
        imageAdapter.submitList(getData())

    }

    private fun setupToolbar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        val titleTxt = supportActionBar?.customView?.findViewById<TextView>(R.id.toolbar_title)
        titleTxt?.text = getString(R.string.photo_choose)
    }

    private fun getData(): ArrayList<ImageModel> {
        val list = arrayListOf<ImageModel>()
        list.add(ImageModel(image = R.drawable.aes))
        list.add(ImageModel(image = R.drawable.aes))
        list.add(ImageModel(image = R.drawable.aes))
        list.add(ImageModel(image = R.drawable.aes))
        list.add(ImageModel(image = R.drawable.aes))
        list.add(ImageModel(image = R.drawable.aes))
        list.add(ImageModel(image = R.drawable.aes))

        return list
    }
}