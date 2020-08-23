package com.example.bsscco.presentation.main.fragments.photos.viewmodels

import androidx.lifecycle.ViewModel
import com.example.bsscco.presentation.common.annotations.OnViewEvent
import com.example.bsscco.presentation.common.viewmodel_events.PushPhotoFragmentEvent
import com.example.bsscco.presentation.common.viewmodel_events.PushPhotoFragmentEventImpl
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewDataImpl
import com.example.bsscco.presentation.main.fragments.photos.view_events.PhotoEventListener
import javax.inject.Inject

class PhotoViewModel @Inject constructor(
        private val pushPhotoActivityEventImpl: PushPhotoFragmentEventImpl
) : ViewModel(), PhotoEventListener,
        PushPhotoFragmentEvent by pushPhotoActivityEventImpl {

    @OnViewEvent
    override fun onPhotoClick(viewData: PhotoViewData) {
        pushPhotoActivityEventImpl.emitEvent((viewData as PhotoViewDataImpl))
    }

    private fun PushPhotoFragmentEventImpl.emitEvent(viewData: PhotoViewDataImpl) {
        event.value = PushPhotoFragmentEvent.EventData(photoId = viewData.id)
    }
}