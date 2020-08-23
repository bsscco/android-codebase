package com.example.bsscco.domain.photos

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: PhotosRepository
) {
    suspend operator fun invoke(page: Int): List<PhotoResponse> = repository.getPhotos(page)
}