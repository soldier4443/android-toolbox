package com.turastory.androidtoolbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.turastory.androidtoolbox.configurable.ActionBarConfigurable

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (this) {
            is ActionBarConfigurable -> {
                supportActionBar?.title = actionBarName
            }
        }
    }
}