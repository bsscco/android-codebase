package com.example.bsscco.presentation.main.fragments.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bsscco.databinding.RefreshableListBinding
import com.example.bsscco.presentation.common.abstracts.ViewModelEventHandler
import com.example.bsscco.presentation.main.fragments.photos.view_binders.PhotosAdapter
import com.example.bsscco.presentation.main.fragments.photos.viewmodels.PhotoViewModel
import com.example.bsscco.presentation.main.fragments.photos.viewmodels.PhotosViewModel
import com.example.bsscco.presentation.utils.extentions.*
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PhotosFragment : DaggerFragment(), ViewModelEventHandler {

    private lateinit var binding: RefreshableListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mainViewModel: PhotosViewModel
    private lateinit var photoViewModel: PhotoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return RefreshableListBinding.inflate(inflater)
                .also { binding -> this.binding = binding }
                .also { binding -> binding.lifecycleOwner = viewLifecycleOwner }
                .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectViewModels()
        initViews()
        observeViewModelEvents()
        startMainViewModel()
    }

    private fun injectViewModels() {
        mainViewModel = activityViewModelProvider(viewModelFactory)
        photoViewModel = viewModelProvider(viewModelFactory)
    }

    private fun initViews() {
        binding.bindDataAndListener()
    }

    private fun RefreshableListBinding.bindDataAndListener() {
        viewData = mainViewModel.viewData
        recyclerView.adapter = PhotosAdapter(
                photoEventListener = photoViewModel
        )
        eventListener = mainViewModel
    }

    private fun observeViewModelEvents() {
        observeCloseActivityEvent(mainViewModel)
        observeBackPressEvent(mainViewModel)

        photoViewModel.observePushPhotoFragmentEvent()
    }

    private fun PhotoViewModel.observePushPhotoFragmentEvent() {
        observeLiveData(pushPhotoFragmentEvent) { eventData ->
            findNavController().navigate(PhotosFragmentDirections.actionPhotosFragmentToPhotoFragment(eventData.photoId))
        }
    }

    private fun startMainViewModel() {
        mainViewModel.start()
    }
}