# MVVM

The following is the basic structure of Model View ViewModel architecture

<img src="https://user-images.githubusercontent.com/22313316/138629117-c12744c3-8ace-466f-8401-23567d94e7d6.png" width=450/>

# ViewModel

The VeiwModel class allows one ot store and manage UI related data in a lifecycle conscious way. It allows the data to survive device configuration changes such as keyboard availiability and screen rotations. 

The ViewModelFactory class is used to instantiate ViewModel object that survives configuration changes. This factory may or may not contain constructor parameters.

If the ViewModel is created inside of the UI controller without the ViewModelProvider, when there is a deivice configuration change like a screen rotation where the UI Controller is destroyed the repective Viewmodel will also be destryoed. 

Instantiating a ViewModel using a ViewModelProvider ensures that the ViewModel is created in association with the given lifecycle scope of the UI Controller.

Example:

```java
	viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
 ```

 The ViewModel should never contain references to fragments, activities, or views, because activities, fragments, and views do not survive configuration changes.

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
