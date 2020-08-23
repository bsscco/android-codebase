package com.example.bsscco.presentation.main.di

import com.example.bsscco.app.di.scopes.FragmentScope
import com.example.bsscco.presentation.main.fragments.photo.PhotoFragment
import com.example.bsscco.presentation.main.fragments.photo.di.PhotoFragmentBindModule
import com.example.bsscco.presentation.main.fragments.photos.PhotosFragment
import com.example.bsscco.presentation.main.fragments.photos.di.PhotosFragmentBindModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBindModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [PhotosFragmentBindModule::class])
    abstract fun contributePhotosFragment(): PhotosFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PhotoFragmentBindModule::class])
    abstract fun contributePhotoFragment(): PhotoFragment
}