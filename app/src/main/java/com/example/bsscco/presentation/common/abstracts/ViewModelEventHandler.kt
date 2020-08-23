package com.example.bsscco.presentation.common.abstracts

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner

interface ViewModelEventHandler {

    fun getViewLifecycleOwner(): LifecycleOwner

    fun requireActivity(): FragmentActivity
}