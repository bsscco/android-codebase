package com.example.bsscco.presentation.main.fragments.photos.di

import androidx.lifecycle.ViewModel
import com.example.bsscco.app.di.singleton_modules.viewmodel.ViewModelKey
import com.example.bsscco.presentation.main.fragments.photos.viewmodels.PhotoViewModel
import com.example.bsscco.presentation.main.fragments.photos.viewmodels.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PhotosFragmentBindModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    abstract fun bindPhotosViewModel(viewModel: PhotosViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PhotoViewModel::class)
    abstract fun bindPhotoViewModel(viewModel: PhotoViewModel): ViewModel
}