# setTheme issue on 34 Android API

## Overview

`ContextThemeWrapper.setTheme(id)` on API <= 33 and API 34 are different implementation

In our project we found that issue in `ThemeKey`.

In 34 API at: https://cs.android.com/android/_/android/platform/frameworks/base/+/ab3cb30aa0ea166c8bcb0531a5a47ca119a000c3:core/java/android/content/res/Resources.java;l=2024

Theme can't be set more then one time. For example:
1. Set Theme A
2. Set Theme B
3. Set Theme A

Theme A not applied properly, drawable cache use last unique theme set (Theme B in example)

## Step to reproduce bug

1. Open project
2. Select "app" project
3. Run app
4. Open "Issue Sample" on 34 API emulator
5. 3rd icon not return its color to new theme

## Workaround solution (may be need app compat version of this)

1. Open project
2. Select "app" project
3. Run app
4. Open "Workaround Sample" on 34 API emulator

### TLDR:

We see that in `main` branch source code of `ThemeKey` are changed.
https://cs.android.com/android/_/android/platform/frameworks/base/+/c2ad00b665d75e3d1dc68c0feb382f852c4d75c5:core/java/android/content/res/Resources.java;l=2041?hl=ru

We have no option to check if new version are fix drawable cache issue, but we assume that hash code need also to be recalculated for correct `equals`/`hashcode` contract  