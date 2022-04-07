### Difference Between `min sdk version`, `target sdk version` and `compile sdk version`

The `min sdk version` is the minimum version of the Android operating system required to run your application.

The `target sdk version` is the version of Android that your app was created to run on.

The `compile sdk version` is the the version of Android that the build tools uses to compile and build the application in order to release, run, or debug.

*Usually the compile sdk version and the target sdk version are the same.*

## Common Dependencies

```kotlin 
    // Architectural Components For ViewModel, LiveData  etc.
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"

    // Room
    implementation "androidx.room:room-runtime:2.2.5"
    kapt "androidx.room:room-compiler:2.2.5" //  plugins { id 'kotlin-kapt' } needed for kapt

    // Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:2.2.5"

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'

    // Coroutine Lifecycle Scopes
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.6.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
    implementation "com.squareup.okhttp3:logging-interceptor:4.5.0"

    // Navigation Components
    implementation "androidx.navigation:navigation-fragment-ktx:2.2.1"
    implementation "androidx.navigation:navigation-ui-ktx:2.2.1"

    // Glide
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    kapt 'com.github.bumptech.glide:compiler:4.11.0' //  plugins { id 'kotlin-kapt' } needed for kapt

```
## SafeArgs

*In order to navigate to a different from the current fragment one has to add the follow dependencies to the **project-level** `build.gradle` file*

```kotlin
// Project level build.gradle 
buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0"
    }
}
```

*We will also need to add the following plugin to the **module-level** `build.gradle` file*

```kotlin
// Module level build.gradle.
plugins {
    id 'androidx.navigation.safeargs.kotlin'
}
```

## View Binding

How to turn view binding on in the module level `build.gradle`

```kotlin
android {
    ...
    buildFeatures {
        viewBinding = true
    }
}
```


