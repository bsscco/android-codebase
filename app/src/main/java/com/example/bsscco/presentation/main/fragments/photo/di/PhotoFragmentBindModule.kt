package com.example.bsscco.presentation.main.fragments.photo.di

import androidx.lifecycle.ViewModel
import com.example.bsscco.app.di.singleton_modules.viewmodel.ViewModelKey
import com.example.bsscco.presentation.main.fragments.photo.viewmodels.PhotoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PhotoFragmentBindModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhotoViewModel::class)
    abstract fun bindPhotoViewModel(viewModel: PhotoViewModel): ViewModel
}