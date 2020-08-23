package com.example.bsscco.presentation.main.fragments.photo.view_data.header

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import com.example.bsscco.presentation.main.fragments.photo.view_data.refreshable_list.PhotoRecyclerData
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewDataImpl
import com.example.bsscco.presentation.utils.WindowSizeUtils

object HeaderViewDataCreator {

    fun toRecyclerData(entity: PhotoResponse): PhotoRecyclerData {
        return entity.toViewData().toRecyclerData()
    }

    private fun PhotoResponse.toViewData(): PhotoViewData {
        return PhotoViewDataImpl(
                id = id,
                title = title,
                imageUrl = url,
                imageWidth = getImageWidth(),
                imageHeight = getImageHeight()
        )
    }

    private fun getImageWidth(): Int {
        return WindowSizeUtils.windowWidth
    }

    private fun getImageHeight(): Int {
        return getImageWidth()
    }

    private fun PhotoViewData.toRecyclerData(): PhotoRecyclerData {
        return PhotoRecyclerData.HeaderRecyclerData(this)
    }
}