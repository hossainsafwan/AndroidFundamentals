# Room and Coroutines

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

