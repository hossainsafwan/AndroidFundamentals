# Android Styling System

In Android you can use themes, styles or view attributes to affect styling. The diagram below summarizes the precedence of each method of styling.

![Screen Shot 2022-01-23 at 5 18 29 PM](https://user-images.githubusercontent.com/22313316/150703118-702ad378-cfbc-4182-aefc-629e1e2ca915.png)

View Attributes

- Use View attributes to set attributes for each view. This is used for custom or one off designs

Styles

- Use a style to create a collection of resuable styling information such as font sizes or colors

Default Styles

- This is the default styling provided by the Android system

Themes

- you use themes to define colors, default fonts

Text appearace

- This is used for styling text attributes only such as `fontFamily`

*How to create themes in Android*

Inside of the styles.xml file add this:

```xml
    <style name="AppTheme" parent="Theme.MaterialComponents.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="android:fontFamily">@font/judson</item>
        <item name="fontFamily">@font/judson</item>
    </style>
```

*How to create style in Android*

Inside of the styles.xml file add this

```xml
    <style name="TextAppearance.Title" parent = "TextAppearance.MaterialComponents.Headline6">
        <item name="android:textSize">24sp</item>
        <item name="android:textColor">#555555</item>
    </style>
```
