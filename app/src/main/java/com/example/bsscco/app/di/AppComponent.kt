package com.example.bsscco.app.di

import android.app.Application
import com.example.bsscco.app.App
import com.example.bsscco.app.di.singleton_modules.ActivityBuilderModule
import com.example.bsscco.app.di.singleton_modules.DataModule
import com.example.bsscco.app.di.singleton_modules.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        ViewModelModule::class,
        ActivityBuilderModule::class,
        DataModule::class,
        AndroidSupportInjectionModule::class
    ]
)

@Singleton
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}