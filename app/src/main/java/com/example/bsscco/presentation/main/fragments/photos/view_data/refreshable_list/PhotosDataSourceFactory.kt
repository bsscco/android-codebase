package com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.DataSource.Factory
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.bsscco.presentation.common.enums.LoadingStatus
import javax.inject.Inject

class PhotosDataSourceFactory @Inject constructor(
    dataSource: PhotosDataSource
) : Factory<Int, PhotosRecyclerData>() {

    val pagedList: LiveData<PagedList<PhotosRecyclerData>> = createPagedList()

    private val _loadingStatus = MutableLiveData<LiveData<LoadingStatus>>(dataSource.loadingStatus)
    val loadingStatus: LiveData<LiveData<LoadingStatus>>
        get() = _loadingStatus

    @Volatile
    private var _dataSource = dataSource
    val dataSource: PhotosDataSource
        get() = _dataSource

    private fun createPagedList(): LiveData<PagedList<PhotosRecyclerData>> {
        return toLiveData(
            PagedList.Config.Builder()
                .setInitialLoadSizeHint(100)
                .setPageSize(100)
                .setPrefetchDistance(10)
                .build()
        )
    }

    override fun create(): DataSource<Int, PhotosRecyclerData> {
        return _dataSource.copy().also {
            _loadingStatus.postValue(it.loadingStatus)
            _dataSource = it
        }
    }
}