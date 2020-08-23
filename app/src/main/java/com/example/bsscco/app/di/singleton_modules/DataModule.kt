package com.example.bsscco.app.di.singleton_modules

import com.example.bsscco.BuildConfig
import com.example.bsscco.data.photos.PhotosRepositoryImpl
import com.example.bsscco.data.photos.sources.remote.PhotosRemoteDataSource
import com.example.bsscco.domain.photos.PhotosRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .client(createClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build()
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.HEADERS
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }))
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()
    }

    private fun createGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }

    @Singleton
    @Provides
    fun providePhotosRemoteDataSource(retrofit: Retrofit): PhotosRemoteDataSource {
        return retrofit.create(PhotosRemoteDataSource::class.java)
    }

    @Singleton
    @Provides
    fun providePhotosRepository(remoteDataSource: PhotosRemoteDataSource): PhotosRepository {
        return PhotosRepositoryImpl(remoteDataSource)
    }
}