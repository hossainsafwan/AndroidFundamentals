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
- RecyclerView instance in layout file to be a cotainer for views
- A layout file for each item of data. 
- A layout manager which handles the organization of UI copmponents in a view
- A view holder which extends the `ViewHolder` class. It contains the view information for displaying one item from the item's layout. View holders have the information that the recyclerView uses to move information efficiently around the screen 
- An adapter which adapts the data to be displayed in a `ViewHolder`. The RecyclerView uses the adapter to figure out how rto display the data on the screen 
