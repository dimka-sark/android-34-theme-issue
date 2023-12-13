package com.dimkasark.theme_issue

import android.os.Build
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.LinearLayout
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity

class WorkaroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        val wrapper = ContextThemeWrapper(this, R.style.GreenIconStyle)

        findViewById<LinearLayout>(R.id.test_container).apply {
            addView(Icon(wrapper))
            wrapper.setThemeCompat(R.style.OrangeIconStyle)
            addView(Icon(wrapper))
            wrapper.setThemeCompat(R.style.GreenIconStyle)
            addView(Icon(wrapper))
        }
    }
}

fun ContextThemeWrapper.setThemeCompat(@StyleRes id: Int) {
    // workaround for theme key issue in https://cs.android.com/android/_/android/platform/frameworks/base/+/ab3cb30aa0ea166c8bcb0531a5a47ca119a000c3:core/java/android/content/res/Resources.java;l=2024
    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
        theme = null
    }
    setTheme(id)
}
