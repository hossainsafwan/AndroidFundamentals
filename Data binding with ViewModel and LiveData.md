# Data binding with ViewModel and LiveData

Data Binding allows views to directly communicate with the ViewModels without the intervention of fragments or activities.

**Before Data Binding**

<img src="https://user-images.githubusercontent.com/22313316/148700897-0db53fb7-7ec0-4df1-aebc-58ab3b8153e0.png" width="550"/> 

**After Data Binding**

![Screen Shot 2022-01-09 at 4 03 29 PM](https://user-images.githubusercontent.com/22313316/148700916-a4a86cbd-69ad-4b85-81d6-2ad376a16cee.png)

**Example:**

Create ViewMode  variable inside layout file

```xml 
<layout ...>

   <data>

       <variable
           name="gameViewModel"
           type="com.example.android.guesstheword.screens.game.GameViewModel" />
   </data>
  
   <androidx.constraintlayout...
```

Send ViewModel to Layout file inside `onCreateView()` after initilization of ViewModel

```kotlin 
binding.gameViewModel = viewModel
```

**Listener Binding**

Listener bindings are binding expressions that run when events such as onClick(), onZoomIn(), or onZoomOut() are triggered. Listener bindings are written as lambda expressions.


```xml 
<Button
   android:id="@+id/skip_button"
   ...
   android:onClick="@{() -> gameViewModel.onSkip()}"
   ... />
```

One issue with DataBinding is that the developer can only see errors during compile time not during the development process itself which would have otherwise been highlighted by Android Studio

## Live Data and Data Binding

LiveData objects cand irectly update UI elements in the layout, with the following changes in the layout file.

```xml
  <TextView
      android:id="@+id/score_text"
      android:text="@{gameViewModel.word}"
```

Then the developer has to set the lifecycle for the livedata updates inside of the UI-Controller

```kotlin
// Specify the fragment view as the lifecycle owner of the binding.
// This is used so that the binding can observe LiveData updates
binding.lifecycleOwner = viewLifecycleOwner
```

## Summary

![Screen Shot 2022-01-09 at 5 25 16 PM](https://user-images.githubusercontent.com/22313316/148703544-b780b7f5-b887-41f1-9350-83aa4ac1ba0f.png)

![Screen Shot 2022-01-09 at 5 25 47 PM](https://user-images.githubusercontent.com/22313316/148703572-8ac81f2e-f856-47a6-820d-8050e4f5fbbc.png)


![Screen Shot 2022-01-09 at 5 26 12 PM](https://user-images.githubusercontent.com/22313316/148703587-f440cb06-e983-40e0-8460-ca5fb12af056.png)
