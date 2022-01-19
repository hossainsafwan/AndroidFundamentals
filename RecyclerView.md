# RecyclerView

Displaying a list or grid of data is one of the most common UI tasks on Android. To facilitate such feature a RecylerView widget is used.

RecylerView is able to facilitate showing a large list in a very efficient manner. It is efficient because:

- RecylerView only does work to draw items which are currently on screen

- If an item is off screen the item is filled with the new content which is now visible and has the old content removed. Effectively recycling the holder of the item.

- When an item changes, RecyclerView has the ability to change that one item instead of redrawing the entire list

## Adapter Pattern

The RecyclerView uses an adapater to transform app data into something the RecyclerView can display without changing how the app stores and processes the data.

To display data in a RecylerView the following is needed:
- Data to display
- RecyclerView instance in layout file to be a container for views
- A layout file for each item of data. 
- A layout manager which handles the organization of UI copmponents in a view
- A view holder which extends the `ViewHolder` class. It contains the view information for displaying one item from the item's layout. View holders have the information that the recyclerView uses to move information efficiently around the screen 
- An adapter which adapts the data to be displayed in a `ViewHolder`. The RecyclerView uses the adapter to figure out how to display the data on the screen 

*Dependency in the module `build.gradle`*

```kotlin
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
```
*RecyclerView Instance in Layout file with LayoutManager attribute*
```xml 
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/sleep_list"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toTopOf="@+id/clear_button"
        app:layout_constraintTop_toBottomOf="@+id/stop_button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"/>
```

*Layout for item*
```xml<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:textSize="24sp"
    android:paddingStart="16dp"
    android:paddingEnd="16dp"
    android:layout_width="match_parent"       
    android:layout_height="wrap_content" />
```

*ViewHolder for items as an `inner class` in the adapter*
```kotlin
    inner class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
```

*An adapter which adapts the data for the `RecyclerView` to be displayed*

```kotlin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.to_do_item.view.*

class TodoAdapter(var items: List<Todo>):RecyclerView.Adapter<TodoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    // Inflate the View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = items[position].title
            checkBox.isChecked = items[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
```


