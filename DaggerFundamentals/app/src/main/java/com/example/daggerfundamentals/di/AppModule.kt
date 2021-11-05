package com.example.daggerfundamentals.di

import android.app.Application
import dagger.Module
import dagger.Provides
/*
* All application level dependencies will go inside of this module.
* Any dependency that will not change for the entire lifetime of the application will
* go inside of this module.
* E.g: Glide, Retrofit
* */
@Module
class AppModule {
    companion object{
        @Provides
        fun someString(): String{
            return "This is a test string"
        }

    }

}