package com.example.bsscco.domain.photos

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse

interface PhotosRepository {

    suspend fun getPhotos(page: Int): List<PhotoResponse>

    suspend fun getPhoto(id: Int): PhotoResponse
}