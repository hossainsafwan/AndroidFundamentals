package com.example.daggerfundamentals.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerfundamentals.BaseApplication
import com.example.daggerfundamentals.R
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

    companion object {
        @Provides
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background)
        }

        @Provides
        fun provideGlideInstance(
            application: BaseApplication,
            requestOptions: RequestOptions
        ): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }

        @Provides
        fun providesAppDrawable(application: BaseApplication) : Drawable {
            return ContextCompat.getDrawable(application, R.drawable.logo)!!
        }

    }

}