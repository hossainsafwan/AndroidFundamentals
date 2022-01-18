# RecyclerView

Displaying a list or grid of data is one of the most common UI tasks on Android. To facilitate such feature a RecylerView widget is used.

RecylerView is able to facilitate showing a large list in a very efficient manner. It is efficient because:

- RecylerView only does work to draw items which are currently on screen

- If an item is off screen the item is filled with the new content which is now visible and has the old content removed. Effectively recycling the holder of the item.

- When an item changes, RecyclerView has the ability to change that one item instead of redrawing the entire list

## Adapter Pattern

