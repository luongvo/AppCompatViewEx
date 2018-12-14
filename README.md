# AppCompatViewEx
[![](https://jitpack.io/v/luongvo/AppCompatViewEx.svg)](https://jitpack.io/#luongvo/AppCompatViewEx)

These features are supported by AndroidX now: https://developer.android.com/jetpack/androidx/androidx-rn#2018-dec-03-appcompat. If you still did not migrate to AndroidX yet, you could use this library for extending support.

## Usage
```
dependencies {
    implementation 'com.github.luongvo:AppCompatViewEx:[LATEST_VERSION]'
}
```

## Feature
Adding more support for these properties below for vector drawables
```
drawableLeftCompat
drawableRightCompat
drawableTopCompat
drawableBottomCompat
```
to
```
AppCompatTextViewEx
AppCompatButtonEx
AppCompatEdiTextEx
```

See sample app for more info: https://github.com/luongvo/AppCompatViewEx/blob/master/app/src/main/res/layout/activity_main.xml
