package com.example.bsscco.presentation.main.fragments.photo.view_data.refreshable_list

import androidx.lifecycle.MutableLiveData
import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import com.example.bsscco.presentation.common.view_data.RefreshableFixSizeListViewDataImpl
import com.example.bsscco.presentation.main.fragments.photo.view_data.header.HeaderViewDataCreator

object RefreshableListViewDataCreator {

    fun create(): RefreshableFixSizeListViewDataImpl {
        return RefreshableFixSizeListViewDataImpl(
                loadingStatus = MutableLiveData(),
                dataList = MutableLiveData()
        )
    }

    fun toRecyclerData(entity: PhotoResponse): List<PhotoRecyclerData> {
        return mutableListOf<PhotoRecyclerData>().apply {
            add(HeaderViewDataCreator.toRecyclerData(entity))
        }
    }
}