package com.dimkasark.theme_issue

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class IssueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        val wrapper = ContextThemeWrapper(this, R.style.GreenIconStyle)

        findViewById<LinearLayout>(R.id.test_container).apply {
            addView(Icon(wrapper))
            wrapper.setTheme(R.style.OrangeIconStyle)
            addView(Icon(wrapper))
            wrapper.setTheme(R.style.GreenIconStyle)
            addView(Icon(wrapper))
        }
    }
}