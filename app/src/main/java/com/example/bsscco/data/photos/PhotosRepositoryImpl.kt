package com.example.bsscco.data.photos

import com.example.bsscco.data.photos.sources.remote.PhotosRemoteDataSource
import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import com.example.bsscco.domain.photos.PhotosRepository
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val remoteDataSource: PhotosRemoteDataSource
) : PhotosRepository {

    override suspend fun getPhotos(page: Int): List<PhotoResponse> {
        return remoteDataSource.getPhotos(page)
    }

    override suspend fun getPhoto(id: Int): PhotoResponse {
        return remoteDataSource.getPhoto(id)
    }
}