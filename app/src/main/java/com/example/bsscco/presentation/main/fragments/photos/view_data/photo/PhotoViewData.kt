package com.example.bsscco.presentation.main.fragments.photos.view_data.photo

interface PhotoViewData {
    val title: String
    val imageUrl: String
    val imageWidth: Int
    val imageHeight: Int
}

data class PhotoViewDataImpl(
        val id: Int,
        override val title: String,
        override val imageUrl: String,
        override val imageWidth: Int,
        override val imageHeight: Int
) : PhotoViewData