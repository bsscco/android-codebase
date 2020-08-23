package com.example.bsscco.data.photos.sources.remote

import com.example.bsscco.data.photos.sources.remote.responses.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotosRemoteDataSource {

    @GET("/photos")
    suspend fun getPhotos(@Query("page") page: Int): List<PhotoResponse>

    @GET("/photos/{id}")
    suspend fun getPhoto(@Path("id") id: Int): PhotoResponse
}