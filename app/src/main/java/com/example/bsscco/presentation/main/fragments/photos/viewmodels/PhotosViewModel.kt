package com.example.bsscco.presentation.main.fragments.photos.viewmodels

import androidx.lifecycle.ViewModel
import com.example.bsscco.presentation.common.annotations.OnViewEvent
import com.example.bsscco.presentation.common.view_events.RefreshableListEventListener
import com.example.bsscco.presentation.common.viewmodel_events.BackPressEvent
import com.example.bsscco.presentation.common.viewmodel_events.BackPressEventImpl
import com.example.bsscco.presentation.common.viewmodel_events.CloseActivityEvent
import com.example.bsscco.presentation.common.viewmodel_events.CloseActivityEventImpl
import com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list.PhotosDataSourceFactory
import com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list.RefreshableListViewDataCreator
import javax.inject.Inject

class PhotosViewModel @Inject constructor(
        private val dataSourceFactory: PhotosDataSourceFactory,
        private val closeActivityEventImpl: CloseActivityEventImpl,
        private val backPressEventImpl: BackPressEventImpl
) : ViewModel(), RefreshableListEventListener,
        CloseActivityEvent by closeActivityEventImpl,
        BackPressEvent by backPressEventImpl {

    val viewData = RefreshableListViewDataCreator.create(dataSourceFactory)

    fun start() {
        if (viewData.pagedList.value == null) {
            loadPhotos()
        }
    }

    private fun loadPhotos() {
        dataSourceFactory.dataSource.invalidate()
    }

    @OnViewEvent
    override fun onPullToRefresh() {
        loadPhotos()
    }
}