# Fragment Navigation

### What is a Fragment?

A Fragment represents a portion of the User Interface inside of an activity which is resuable. 
It has its own layout and its own lifectycle. One can also add or remove fragments inside of an Activity.

*To make a Fragment compile one has to create a binding object inflate the Fragment's view*

```kotlin
package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)
        return binding.root
    }
}
```

*To facilitate navigation developer needs the following variable for the navigation library in the project level gradle file*

```xml
buildscript {
    ext {
        ...
        navigationVersion = "2.3.0"
        ...
    }
    ...
}
```

*Add the following dependency to the module level gradle file*
```xml
dependencies {
    ....
    //Navigation Library
    implementation "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    implementation "androidx.navigation:navigation-ui-ktx:$navigationVersion"
  ...
}
```

*Create the navigation graph by right clicking on `res` > Android Resource File > selecting Navigation form Android Resource type*

### Navigation Host Fragment

The navigation host fragment is often called the `NavHostFragment` and facilitates the launching and removing of fragments directed by the navigation graph.
It is defined in the layout file of one of the activities in the following manner

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <!-- TODO (04) Add a fragment tag for the titleFragment in the LinearLayout
                 Use @+id/titleFragment for the android:id
                 Use com.example.android.navigation.TitleFragment for the android:name
                 Use match_parent for the layout_height and layout_width -->
            <fragment
                android:id="@+id/myNavHostFragment"
                android:name="androidx.navigation.fragment.NavHostFragment"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:navGraph = "@navigation/navigation"
                app:defaultNavHost="true" />

        </LinearLayout>

</layout>

```
