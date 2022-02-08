# AndroidFundamentals
Lessons for Android Fundamentals

- [Activities and Fragments](#activities-and-fragments)
- [MVVM](#mvvm)
- [View](#fragment-navigation)
- [ViewModels](#view-models)
- [Repository](#repository)
- [Coroutines](#coroutines)
- [Room Database Library](#room-database-library)
- [Retrofit library]()
- [Flows](#flows)
- [Clean Architecture](#clean-architecture)
- [Use Cases](#use-cases)




# Activities and Fragments

### What is an activity in android?

An activity is a screen in an android application which has its own layout, lifecycle conisting of various states.

### What is a fragment in android?

A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.

### What is the activity lifecycle?

An activity lifecycle consists of the different states an activity goes through based on various inputs from the user.

![activity_lifecycle](https://user-images.githubusercontent.com/22313316/145726483-bd00d4b3-50a0-449a-bdf0-46c55f938dac.png)\
<em>Fig 1: Activity Lifecycle</em>

`onCreate()` : The `onCreate()` method is where you should do any one-time initializations for your activity. For example, in `onCreate()` you inflate the layout, define click listeners, or set up data binding. This is the first method that is called and is called once during the activity's lifecycle.

`onStart()` : The `onStart()` method is called right after the `onCreate()`. After this method is complete the user can see the activity on the screen. This is also called when you are bringing the activty back to the screen after it was not visible to the user, after `onStop()`.

`onResume()`: This is called right after `onStart()` This is also called when you are making the activity active again after it was rendereced inactive due to another android component on the screen.

`onPause()`: This is called when the activity is visible to the user but is inactive. You can go from this state to `onResume()` directly when the activity is made active again.

`onStop()`: This is called when the activity is no longer visible to the user but is also not destroyed. The lifecycle goes from this state to `onStart()` when the activity is made visible again an example of this state being initiated is when the user minimizes the app.

`onDestroy()`: This is called when the activity is getting destroyed. For example when one closes the app.

`onRestart()`: This is called when the activity goes from the `onStop()` state to the `onStart()` state.

## Fragment Lifecycle

A fragment is a reusable component in android which has its own lifecycle and layout. We can have multiple fragments inside of one activity.

### Lifecycle of a fragment and its corelation to its activity

<img src="https://user-images.githubusercontent.com/22313316/145733383-a2c0b71f-699f-48e3-8031-3d54795349e1.png"  width="700" height="650" />\
<em>Fig 2: Relationship Between Activity and Fragment Lifecycles</em>


`onAttach()`: Called when the fragment is associated with its owner activity.

`onCreate()`: Similarly to onCreate() for the activity, onCreate() for the fragment is called to do initial fragment creation (other than layout).

`onCreateView()`: Called to inflate the fragment's layout.

`onViewCreated()`: Called immediately after onCreateView() has returned, but before any saved state has been restored into the view.

`onStart()`: Called when the fragment becomes visible; parallel to the activity's onStart().

`onResume()`: Called when the fragment gains the user focus; parallel to the activity's onResume().

`onPause()`: Called when the fragment loses the user focus; parallel to the activity's onPause().

`onStop()`: Called when the fragment is no longer visible on screen; parallel to the activity's onStop().

`onDestroyView()`: Called when the fragment's view is no longer needed, to clean up the resources associated with that view.

# MVVM

The following is the basic structure of Model View ViewModel architecture

<img src="https://user-images.githubusercontent.com/22313316/138629117-c12744c3-8ace-466f-8401-23567d94e7d6.png" width=450/>

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


# View Models

The VeiwModel class allows one ot store and manage UI related data in a lifecycle conscious way. It allows the data to survive device configuration changes such as keyboard availiability and screen rotations. 

The ViewModelProvider class is used to instantiate ViewModel object that survives configuration changes. This factory may or may not contain constructor parameters.

If the ViewModel is created inside of the UI controller without the ViewModelProvider, when there is a deivice configuration change like a screen rotation where the UI Controller is destroyed the repective Viewmodel will also be destryoed. 

Instantiating a ViewModel using a ViewModelProvider ensures that the ViewModel is created in association with the given lifecycle scope of the UI Controller.

Example:

```java
	viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
 ```

The ViewModel should never contain references to fragments, activities, or views, because activities, fragments, and views do not survive configuration changes.
The ViewModel is destroyed when the respective UI-Controller is finished.

 # ViewModelFactory

 In order to understand what ViewModelFactory is we have to first understand the factory method pattern. This pattern is a creational design pattern that uses factory methods to create objects that is an instance of the same class. 

Sometimes you need the data right when the viewModel is initialized. We use a ViewModelFactory to create a parameterized consructor for the viewModel using viewModelFactory

Inside of UI-Controller (Activity or Fragment)

Example: ViewModelFactory

```java 
class ScoreViewModelFactory(private val finalScore: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) return ScoreViewModel(finalScore) as T
        throw  IllegalArgumentException("Unknown ViewModel class")
    }

}
```

Example: Instantiating ViewModel inside of UI-Controller

```java 
viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)
viewModel = ViewModelProvider(this,viewModelFactory).get(ScoreViewModel::class.java)
binding.scoreText.text = viewModel.score.toString()
```

# Summary

![Summary](https://user-images.githubusercontent.com/22313316/148665124-e0686fd4-56ba-454e-af9e-da5489ea9edc.png)


*Source: [ViewModels Codelabs](https://developer.android.com/codelabs/kotlin-android-training-view-model?index=..%2F..android-kotlin-fundamentals#9)*

# Repository


# Coroutines

In order to understand coroutines we have to first understand how our applications work from an Operating systems standpoint first. When we launch our application, we launch an instance of our program. We call this instance a process. The process is executed by a thread. 

This thread in Android is often referred to as the main thread. A thread can be thought of as an infinite loop that is constantly running and executing multiple tasks. 

One of major tasks that the Main thread or UI thread runs is drawing of the UI. In fact the main thread draws the UI of your application 60 times per second. This thread along with  drawing the uUI can perform other inexpensive opertaions such as logical or mathematical operations. However, some operations such as a network call or a database query can take an unexpected period of time. Waiting for this type of operations will cause your application to freeze.

To prevent this we have to create a new paradigm of programming called asynchronous programming. Asynchronous programming allows these expensive operations to take place in a manner such that the main thread is not blocked. 



Running a long running task such as reading an entity from a database or making a call to the internet can cause delays in the application and disrupt the user experience if they are run on the main thread. To overcome this issue coroutines are used. 

## Properties of Corroutines:

- Coroutines are asynchronous:
Coroutine run independently to the main execution steps of the program. This is acheived by running the expernsive operation in a background thread.

- Coroutines are non-blocking:
Coroutines are non-blocking meaning the main or UI-thread is not stopped while coroutines are running.

- Coroutines use suspend functions to make asynchronous code sequential

Coroutiners can suspend execution without blocking, the execution. The main difference being that when a thread is suspended other work can happen whereas when a thread is blocked all work on the thread is stopped.

![Screen Shot 2022-02-07 at 7 43 39 PM](https://user-images.githubusercontent.com/22313316/152897918-28c84398-3f4e-4f3e-a62b-6ac975ebb63b.png)


To use coroutines in Kotlin three components are needed:

- A job
- A dispatcher
- A scope

Job: Basically, a job is anything that can be canceled. Every coroutine has a job, and you can use the job to cancel the coroutine. Jobs can be arranged into parent-child hierarchies. Canceling a parent job immediately cancels all the job's children, which is a lot more convenient than canceling each coroutine manually.

Dispatcher: The coroutine dispatcher determines what thread or threads the corresponding coroutine uses for its execution. The coroutine dispatcher can confine coroutine execution to a specific thread, dispatch it to a thread pool, or let it run unconfined. There are three types of dispatcher based upon the type of operation being executed by the coroutine.

- Default: CPU intensive tasks such as sorting a large list 
- Main: Lightweight work such as UI functions or update LiveData
- IO: Network or database calls

Scope: Scope in Kotlin's coroutines can be defined as the restrictions within which the Kotlin coroutines are being executed. Scopes help to predict the lifecycle of the coroutines.


The general pattern for using coroutines to retrieve data froma a databse is as follows:

1. create a method with a scope for the operation
2. call a suspend function which does calls a query from the DAO 

```kotlin

private fun  performOperation() {
	viewModelScope.launch {
		suspendfunction()
	}
}

private suspend fun suspendFunciton(){
	longRunningOperation()
}
```

# Summary

![Screen Shot 2022-01-16 at 7 22 24 PM](https://user-images.githubusercontent.com/22313316/149684152-89294381-6a5f-4b86-b3d5-393a576aecf8.png)

*Source: [Coroutines and Room](https://developer.android.com/codelabs/kotlin-android-training-coroutines-and-room#4)*

# Room Database Library

What is Room?

Room is a database library that is part of the Android Jetpack libraries. It is an abstraction on top of SQLite database. Room simplifies the process of setting up configuring and interacting with the database. Room also provides the ability for your app to interact with the database using ordinary function calls. It has a query syntax allowing you to search data.

The following diagram provides information on which secdtion of the your application, Room operates in:

![Screen Shot 2022-01-15 at 3 14 50 PM](https://user-images.githubusercontent.com/22313316/149636421-7ebb1432-acd4-4205-a055-f3512aeaacf9.png)

Entity: An entity represents an object along with its properties which is to be stored in a database. Each instance of an entity describes a row in a table. The entity has the mapping which lets Room know how the data is represented and how it can be interacted with. 

Queries: A query is a request foir information from a database table or from a combination of tables. Queries can be of 4 types: Creating, Reading, Updating and Deleting.

Room converts kotlin data classes into entities which can be stred in SQLite database tabels and create functions which can be used to make queries. 

Each entity is defined as an anotatted data class and interactions with that entity is done via an anotated interface called a data access object or **DAO**.

## Entity

How to declare an entity:

```kotlin 

import androidx.room.Entity

@Entity(tableName = "daily_sleep_quality_table")
data class SleepNight(
    var nightID: Long = 0L,
    val startTimeMilli: Long = System.currentTimeMillis(),
    var endTimeMilli: Long = startTimeMilli,
    var sleepQuality: Int = -1
)

```

## DAO

DAO provides convenience methods to create, read, update and delete entities in a database.

When using Room database, the database is queried using Kotlin fucntions. These Kotlin function map to SQL queries. the developer has to define this mapping in the DAO using annotations and Room creates the necessary code needed to complete the mapping.

Example:

```kotlin
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao{
    @Insert
    fun insert(night: SleepNight)

    @Update
    fun query(night: SleepNight)

    @Query("SELECT * from daily_sleep_quality_table WHERE nightID = :key")
    fun get(key: Long): SleepNight?

    @Query("DELETE from daily_sleep_quality_table")
    fun clear()

    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightID DESC LIMIT 1")
    fun getTonight(): SleepNight?

    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightID")
    fun getAllNights(): LiveData<List<SleepNight>>

}


```

## Database

Example:

Template script to create database
```kotlin 
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    abstract val sleepDatabaseDao: SleepDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SleepDatabase? = null

        fun getInstance(context: Context): SleepDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

```

# Summary

![Screen Shot 2022-01-16 at 1 43 35 AM](https://user-images.githubusercontent.com/22313316/149650164-9bebba6d-4b0e-469e-a142-a028a81d6a3a.png)

# Retrofit

# Flows

# Clean Architecture

# Use Cases





