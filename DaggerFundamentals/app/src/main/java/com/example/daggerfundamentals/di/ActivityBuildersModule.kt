package com.example.daggerfundamentals.di

import com.example.daggerfundamentals.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
* Modules in Dagger are units which consists of the dependencies and the locations
* where dependencies need to be injected @ContributesAndroidInjector states to Dagger
* where dependencies need to be injected and @Provides annotation tells Dagger what is the dependency
* Modules are directed to components which control which dependencies need to go where
* */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity

}