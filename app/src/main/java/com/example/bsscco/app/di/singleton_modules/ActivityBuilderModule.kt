package com.example.bsscco.app.di.singleton_modules

import com.example.bsscco.presentation.main.MainActivity
import com.example.bsscco.presentation.main.di.MainActivityBindModule
import com.example.bsscco.app.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityBindModule::class])
    abstract fun contributeMainActivity(): MainActivity
}