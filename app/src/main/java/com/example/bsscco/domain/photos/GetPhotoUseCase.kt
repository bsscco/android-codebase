package com.example.bsscco.domain.photos

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(
    private val repository: PhotosRepository
) {
    suspend operator fun invoke(id: Int): PhotoResponse = repository.getPhoto(id)
}