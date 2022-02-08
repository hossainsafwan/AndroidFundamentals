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

Dispatcher: The dispatcher sends off coroutines to run on various threads. For example, Dispatchers.Main runs tasks on the main thread, and Dispatchers.IO offloads blocking I/O tasks to a shared pool of threads.

Scope: A coroutine's scope defines the context in which the coroutine runs. A scope combines information about a coroutine's job and dispatchers. Scopes keep track of coroutines. When you launch a coroutine, it's "in a scope," which means that you've indicated which scope will keep track of the coroutine.


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
