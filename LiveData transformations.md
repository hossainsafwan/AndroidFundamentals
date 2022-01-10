# LiveData transformations

LiveData can be transformed from one type and format to another using `Transformations.map`

```kotlin
  //Timer
  private var _currentTime = MutableLiveData<Long>()
  val currentTime: LiveData<Long> get() = _currentTime

  // The String version of the current time
  val currentTimeString = Transformations.map(currentTime) { time->
      DateUtils.formatElapsedTime(time)
  }
```
