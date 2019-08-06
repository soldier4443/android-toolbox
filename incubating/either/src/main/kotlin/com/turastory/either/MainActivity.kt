package com.turastory.either

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.turastory.androidtoolbox.core.enableFullscreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableFullscreen()
        setContentView(R.layout.activity_main)
    }
}