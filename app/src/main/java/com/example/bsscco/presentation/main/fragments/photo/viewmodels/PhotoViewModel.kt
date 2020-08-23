package com.example.bsscco.presentation.main.fragments.photo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bsscco.domain.photos.GetPhotoUseCase
import com.example.bsscco.presentation.common.annotations.OnViewEvent
import com.example.bsscco.presentation.common.enums.LoadingStatus
import com.example.bsscco.presentation.common.view_data.RefreshableFixSizeListViewData
import com.example.bsscco.presentation.common.view_events.RefreshableListEventListener
import com.example.bsscco.presentation.main.fragments.photo.view_data.refreshable_list.RefreshableListViewDataCreator
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoViewModel @Inject constructor(
        private val getPhotoUseCase: GetPhotoUseCase
) : ViewModel(), RefreshableListEventListener {

    private var photoId: Int = -1

    private val _viewData = RefreshableListViewDataCreator.create()
    val viewData: RefreshableFixSizeListViewData
        get() = _viewData

    fun start(photoId: Int) {
        this.photoId = photoId
        loadPhoto()
    }

    private fun loadPhoto() {
        viewModelScope.launch {
            runCatching {
                _viewData.loadingStatus.value = LoadingStatus.LOADING
                _viewData.dataList.value = RefreshableListViewDataCreator.toRecyclerData(getPhotoUseCase(photoId))
                _viewData.loadingStatus.value = LoadingStatus.SUCCEEDED
            }.onFailure { exception ->
                handleLoadingFailed(exception)
            }
        }
    }

    private fun handleLoadingFailed(exception: Throwable) {
        exception.printStackTrace()
        when (exception) {
            is CancellationException -> _viewData.loadingStatus.postValue(LoadingStatus.NONE)
            else -> _viewData.loadingStatus.postValue(LoadingStatus.FAILED)
        }
    }

    @OnViewEvent
    override fun onPullToRefresh() {
        loadPhoto()
    }
}