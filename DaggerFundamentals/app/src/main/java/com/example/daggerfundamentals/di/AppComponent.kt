package com.example.daggerfundamentals.di



import com.example.daggerfundamentals.BaseApplication

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule //support library compatible with more versions
import javax.inject.Singleton

@Singleton //By annotating a component with a scope we state to Dagger that this component owns this particular scope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class
    ]
)
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): AppComponent
    }
}