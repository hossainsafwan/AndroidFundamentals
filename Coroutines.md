# Coroutines

Running a long running task such as reading a entity from a database or making a call to the internet can cause delays in the application and disrupt the user experience if they are run on the main thread. To overcome this issue coroutines are used. 

Properties of Corroutines:

- Coroutines are asynchronous 
- Coroutines are non-blocking
- Coroutines use suspend functions to make asynchronous code sequential

Coroutine run independently to the main execution steps of the program. This could be in parallel or in a seperate processor.

Coroutines are non-blocking meaning the main or UI-thread is not stopped while coroutines are running.

Coroutiners can suspend execution without blocking, the execution. The main difference being that when a thread is suspended other work can happen whereas when a thread is blocked all work on the thread is stopped.

To use coroutines in Kotlin three components are needed:

- A job
- A dispatcher
- A scope

**Job:** A job is anything that can be cancelled. Every coroutine has a job and the job can be used to cancel the coroutine. 

**Disptcher:** A dispatcher sends of coroutines on various threads.

**Scope:** Scope keeps track of coroutines. When coroutines are launched its in a scope which means you have indicated which scope will keep track of the coroutines.


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

