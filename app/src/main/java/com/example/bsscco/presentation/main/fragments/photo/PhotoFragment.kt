package com.example.bsscco.presentation.main.fragments.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.bsscco.databinding.RefreshableFixSizeListBinding
import com.example.bsscco.presentation.common.abstracts.ViewModelEventHandler
import com.example.bsscco.presentation.main.fragments.photo.view_binders.PhotoAdapter
import com.example.bsscco.presentation.main.fragments.photo.viewmodels.PhotoViewModel
import com.example.bsscco.presentation.utils.extentions.viewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PhotoFragment : DaggerFragment(), ViewModelEventHandler {

    private val args: PhotoFragmentArgs by navArgs()
    private lateinit var binding: RefreshableFixSizeListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mainViewModel: PhotoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return RefreshableFixSizeListBinding.inflate(inflater)
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
        mainViewModel = viewModelProvider(viewModelFactory)
    }

    private fun initViews() {
        binding.bindDataAndListener()
    }

    private fun RefreshableFixSizeListBinding.bindDataAndListener() {
        viewData = mainViewModel.viewData
        recyclerView.adapter = PhotoAdapter()
        eventListener = mainViewModel
    }

    private fun observeViewModelEvents() {
    }

    private fun startMainViewModel() {
        mainViewModel.start(args.photoId)
    }
}