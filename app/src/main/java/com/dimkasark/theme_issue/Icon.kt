package com.dimkasark.theme_issue

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView


class Icon(context: Context): AppCompatImageView(context) {
    init {
        setImageResource(R.drawable.check_48)
    }
}