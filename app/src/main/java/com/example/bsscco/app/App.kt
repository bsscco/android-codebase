package com.example.bsscco.app

import com.example.bsscco.app.di.DaggerAppComponent
import com.example.bsscco.presentation.utils.WindowSizeUtils
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    companion object {
        private lateinit var _instance: App
        val instance: App
            get() = _instance
    }

    init {
        _instance = this
        WindowSizeUtils.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}