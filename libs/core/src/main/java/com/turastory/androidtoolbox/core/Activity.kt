package com.turastory.androidtoolbox.core

import android.app.Activity
import android.view.Window
import android.view.WindowManager

fun Activity.enableFullscreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
}
