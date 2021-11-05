package com.example.daggerfundamentals.di



import com.example.daggerfundamentals.BaseApplication

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule //support library compatible with more versions

@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): AppComponent
    }
}