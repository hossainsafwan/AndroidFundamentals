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


