package com.example.bsscco.presentation.main.fragments.photos.view_data.photo

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list.PhotosRecyclerData
import com.example.bsscco.presentation.utils.WindowSizeUtils

object PhotoViewDataCreator {

    fun toRecyclerData(cards: List<PhotoResponse>): List<PhotosRecyclerData> {
        return cards.map { card ->
            card.toViewData().toRecyclerData()
        }
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
        return getImageWidth() / 2
    }

    private fun PhotoViewData.toRecyclerData(): PhotosRecyclerData {
        return PhotosRecyclerData.PhotoRecyclerData(this)
    }
}