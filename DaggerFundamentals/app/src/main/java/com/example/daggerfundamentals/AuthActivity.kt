package com.example.daggerfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

//If we are using @ContributesAndroidInjector then we have to use DaggerAppCompatActivity()
class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var str: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Log.d("safwan", str)
    }
}