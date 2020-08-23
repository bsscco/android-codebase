package com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import com.example.bsscco.domain.photos.GetPhotosUseCase
import com.example.bsscco.presentation.common.enums.LoadingStatus
import com.example.bsscco.presentation.utils.recycler_view.SimplePageKeyedDataSource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PhotosDataSource @Inject constructor(
        private val getPhotosUseCase: GetPhotosUseCase,
        private val recyclerDataCreator: PhotosRecyclerDataCreator
) : SimplePageKeyedDataSource<Int, PhotosRecyclerData>() {

    private val _loadingStatus = MutableLiveData<LoadingStatus>()
    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus

    fun copy(): PhotosDataSource {
        return PhotosDataSource(getPhotosUseCase, recyclerDataCreator)
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PhotosRecyclerData>) {
        runCatching {
            _loadingStatus.postValue(LoadingStatus.LOADING)
            val data = getPhotos(1, params.requestedLoadSize).toRecyclerData()
            callback.onResult(data, null, 2)
            _loadingStatus.postValue(LoadingStatus.SUCCEEDED)
        }.onFailure { exception ->
            handleLoadingFailed(exception)
        }
    }

    private fun getPhotos(page: Int, per: Int): List<PhotoResponse> {
        return runBlocking { getPhotosUseCase(page) }
    }

    private fun List<PhotoResponse>.toRecyclerData(): List<PhotosRecyclerData> {
        return recyclerDataCreator.create(this)
    }

    private fun handleLoadingFailed(exception: Throwable) {
        exception.printStackTrace()
        when (exception) {
            is CancellationException -> _loadingStatus.postValue(LoadingStatus.NONE)
            else -> _loadingStatus.postValue(LoadingStatus.FAILED)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PhotosRecyclerData>) {
        runCatching {
            _loadingStatus.postValue(LoadingStatus.LOADING)
            val data = getPhotos(params.key, params.requestedLoadSize).toRecyclerData()
            callback.onResult(data, params.key + 1)
            _loadingStatus.postValue(LoadingStatus.SUCCEEDED)
        }.onFailure { exception ->
            handleLoadingFailed(exception)
        }
    }
}