package com.example.daggerfundamentals

import com.example.daggerfundamentals.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
/*
* This class exists for the entirety of the Application
* */
class BaseApplication: DaggerApplication() {
    //This will return the AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}