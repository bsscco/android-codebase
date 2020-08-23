package com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewDataCreator
import javax.inject.Inject

class PhotosRecyclerDataCreator @Inject constructor() {

    fun create(entity: List<PhotoResponse>): List<PhotosRecyclerData> {
        return mutableListOf<PhotosRecyclerData>().apply {
            addAll(PhotoViewDataCreator.toRecyclerData(entity))
        }
    }
}