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
        android:id="@+id/recycler_view"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@id/edit_text"
        app:layout_constraintTop_toTopOf="parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"/>
```

*Layout for item*
```xml<?xml version="1.0" encoding="utf-8"?>
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="24dp"
        android:text="To do Item"
        android:layout_marginTop="16dp"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"
        app:layout_constraintEnd_toStartOf="@id/checkBox"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <CheckBox
        android:id="@+id/checkBox"
        android:layout_marginEnd="16dp"
        android:layout_marginTop="8dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
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

*Set the adapter to the `RecyclerView` inside of an activity or fragment*

```kotlin
        var toDoList = mutableListOf<Todo>(
            Todo("Get groceries", false),
            Todo("Finish android fundamentals Codelabs", true),
            Todo(";)", false),
            )

        val adapter = TodoAdapter(toDoList)
        binding.recyclerView.adapter = adapter
```


## DiffUtil

DiffUtil is a utility class whih compares differences between two lists and provides a list of update operations to convert one list into another list. It uses Eugene Myers difference alogorithm to accomplish this. 

The advanatage to using diffUtils is that only the views for which the data has changed will be redrawn and the other views in the recylcerview will remain the same.

This is an alternative to notifyDataSetChanged() which is not efficient as it updates all the views in the recyclerview.

```kotlin
class ListDiffUtil(private val oldList: List<Person>, private val newList: List<Person>): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList[oldItemPosition].id != newList[newItemPosition].id
            || oldList[oldItemPosition].age != newList[newItemPosition].age
            || oldList[oldItemPosition].name != newList[newItemPosition].name) {
            return false
        }
        return true
    }
}
```

