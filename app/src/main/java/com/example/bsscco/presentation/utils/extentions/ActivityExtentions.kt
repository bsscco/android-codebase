package com.example.bsscco.presentation.utils.extentions

import android.app.Activity
import androidx.annotation.IdRes
import androidx.navigation.findNavController

fun Activity.setIntentExtrasToStartFragmentArgs(@IdRes navHostFragmentId: Int) {
    findNavController(navHostFragmentId).apply { setGraph(graph, intent.extras) }
}