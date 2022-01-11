# LiveData and LiveDataObservers

LiveData, which is one of the Android Architecture Components, lets you build data objects that notify views when the underlying database changes.

To use the LiveData class, you set up "observers" (for example, activities or fragments) that observe changes in the app's data. LiveData is lifecycle-aware, so it only updates app-component observers that are in an active lifecycle state.

## Characteristics of LiveData

- LiveData is observable, which means that an observer is notified when the data held by the 
LiveData object changes.

- LiveData holds data; LiveData is a wrapper that can be used with any data

- LiveData is lifecycle-aware. When you attach an observer to the LiveData, the observer is associated with a LifecycleOwner (usually an Activity or Fragment). The LiveData only updates observers that are in an active lifecycle state such as STARTED or RESUMED.

To observe an object you need to use a LifecycleOwner. When observing an object from a fragmemnt use the viewLifecycleOwner since the view is sometimes destroyed before the fragment is destroyed.

Why use viewLifecycleOwner?
Fragment views get destroyed when a user navigates away from a fragment, even though the fragment itself is not destroyed. This essentially creates two lifecycles, the lifecycle of the fragment, and the lifecycle of the fragment's view. Referring to the fragment's lifecycle instead of the fragment view's lifecycle can cause subtle bugs when updating the fragment's view. Therefore, when setting up observers that affect the fragment's view you should:

1. Set up the observers in onCreateView()

2. Pass in viewLifecycleOwner to observers

**Example:**

```kotlin 
//Setting up observers for LiveData
viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
    binding.scoreText.text = newScore.toString()
})
```

LiveData should be encapsulated inside the ViewModel in such a way such that the data can be changed by the ViewModel but only read by the UI-Controller.

This is done inside Kotlin by something called a backing-property. A backing property allows one to return something from a getter versus the object itself.
This will be used inside of the ViewModel to allow the UI-Controller to only access the immutable LiveData object.

**Example:**

```kotlin 
private val _score = MutableLiveData<Int>()
val score: LiveData<Int> get() = _score
```

## Summary

![Screen Shot 2022-01-09 at 2 59 37 PM](https://user-images.githubusercontent.com/22313316/148698567-dea66849-4df3-4ecf-a104-b8918536c84d.png)


