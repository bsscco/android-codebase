package com.example.bsscco.presentation.utils

import android.app.Activity
import android.app.Application
import android.graphics.Point

object WindowSizeUtils {

    private val windowSize = Point()

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(object : SimpleActivityLifecycleCallbacks() {
            override fun onActivityStarted(activity: Activity) {
                activity.windowManager.defaultDisplay.getSize(windowSize)
            }
        })
    }

    val windowWidth: Int
        get() = windowSize.x

    val windowHeight: Int
        get() = windowSize.y
}