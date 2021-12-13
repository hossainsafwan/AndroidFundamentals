# Activities and Fragments

### What is an activity in android?

An activity is a screen in an android application which has its own layout, lifecycle conisting of various states.

### What is a fragment in android?

A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.

### What is the activity lifecycle?

An activity lifecycle consists of the different states an activity goes through based on various inputs from the user.

![activity_lifecycle](https://user-images.githubusercontent.com/22313316/145726483-bd00d4b3-50a0-449a-bdf0-46c55f938dac.png)

`onCreate()` : The `onCreate()` method is where you should do any one-time initializations for your activity. For example, in `onCreate()` you inflate the layout, define click listeners, or set up data binding. This is the first method that is called and is called once during the activity's lifecycle.

`onStart()` : The `onStart()` method is called right after the `onCreate()`. After this method is complete the user can see the activity on the screen. This is also called when you are bringing the activty back to the screen after it was not visible to the user, after `onStop()`.

`onResume()`: This is called right after `onStart()` This is also called when you are making the activity active again after it was rendereced inactive due to another android component on the screen.

`onPause()`: This is called when the activity is visile to the user but is inactive. You can go from this state to `onResume()` directly when the activity is made active again.

`onStop()`: This is called when the activity is no longer visible to the user but is also not destroyed. The lifecycle goes from this state to `onStart()` when the activity is made visible again an example of this state being initiated is when the user minimizes the app.

`onDestroy()`: This is called when the activity is getting destroyed. For example when one closes the app.

`onRestart()`: This is called when the activity goes from the `onStop()` state to the `onStart()` state.

## Fragment Lifecycle

A fragment is a reusable component in android which has its own lifecycle and layout. We can have multiple fragments inside of one activity.

### Lifecycle of a fragment and its corelation to its activity

<img src="https://user-images.githubusercontent.com/22313316/145733383-a2c0b71f-699f-48e3-8031-3d54795349e1.png"  width="700" height="650" />

`onAttach()`: Called when the fragment is associated with its owner activity.

`onCreate()`: Similarly to onCreate() for the activity, onCreate() for the fragment is called to do initial fragment creation (other than layout).

`onCreateView()`: Called to inflate the fragment's layout.

`onViewCreated()`: Called immediately after onCreateView() has returned, but before any saved state has been restored into the view.

`onStart()`: Called when the fragment becomes visible; parallel to the activity's onStart().

`onResume()`: Called when the fragment gains the user focus; parallel to the activity's onResume().

`onPause()`: Called when the fragment loses the user focus; parallel to the activity's onPause().

`onStop()`: Called when the fragment is no longer visible on screen; parallel to the activity's onStop().

`onDestroyView()`: Called when the fragment's view is no longer needed, to clean up the resources associated with that view.


