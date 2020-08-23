package com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import androidx.paging.PagedList
import com.example.bsscco.presentation.common.abstracts.RecyclerData
import com.example.bsscco.presentation.common.view_data.RefreshableListViewData

object RefreshableListViewDataCreator {

    fun create(dataSourceFactory: PhotosDataSourceFactory): RefreshableListViewData {
        return RefreshableListViewData(
            loadingStatus = dataSourceFactory.loadingStatus.switchMap { it },
            pagedList = dataSourceFactory.pagedList as LiveData<PagedList<RecyclerData>>
        )
    }
}