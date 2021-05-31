package com.example.glleryapp.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.glleryapp.R
import com.example.glleryapp.data.model.ImageModel
import com.example.glleryapp.utils.ImagesGallery
import kotlinx.android.synthetic.main.activity_gallery.*


class GalleryActivity : AppCompatActivity() {

    private val imageAdapter by lazy {
        ImageAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        setupToolbar()
        checkPermissions()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerViewImages.adapter = imageAdapter
        recyclerViewImages.layoutManager = GridLayoutManager(this, 3)
        //imageAdapter.addItems(ImagesGallery.listOfImages(this))
    }

    private fun setupToolbar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        val titleTxt = supportActionBar?.customView?.findViewById<TextView>(R.id.toolbar_title)
        titleTxt?.text = getString(R.string.photo_choose)
    }

    private fun checkPermissions() {
        if ((checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
            && (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
        ) {
            val permission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            val permissionCoarse = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            requestPermissions(permission, 1)
            requestPermissions(permissionCoarse, 2)
        } else {
            imageAdapter.addItems(ImagesGallery.listOfImages(this))
        }
    }
}