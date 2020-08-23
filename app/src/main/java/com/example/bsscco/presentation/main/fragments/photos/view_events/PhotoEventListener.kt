package com.example.bsscco.presentation.main.fragments.photos.view_events

import com.example.bsscco.presentation.common.annotations.OnViewEvent
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData

interface PhotoEventListener {
    @OnViewEvent
    fun onPhotoClick(viewData: PhotoViewData)
}