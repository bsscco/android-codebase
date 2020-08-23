package com.example.bsscco.presentation.utils.extentions

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.example.bsscco.presentation.common.abstracts.ViewModelEventHandler
import com.example.bsscco.presentation.common.viewmodel_events.BackPressEvent
import com.example.bsscco.presentation.common.viewmodel_events.CloseActivityEvent

@MainThread
inline fun <T> ViewModelEventHandler.observeLiveData(
    liveData: LiveData<T>,
    crossinline onChanged: (T) -> Unit
) {
    liveData.observe(getViewLifecycleOwner(), onChanged)
}

fun ViewModelEventHandler.observeCloseActivityEvent(viewModelEvent: CloseActivityEvent) {
    observeLiveData(viewModelEvent.closeActivityEvent) {
        requireActivity().finish()
    }
}

fun ViewModelEventHandler.observeBackPressEvent(viewModelEvent: BackPressEvent) {
    observeLiveData(viewModelEvent.backPressEvent) {
        requireActivity().onBackPressed()
    }
}