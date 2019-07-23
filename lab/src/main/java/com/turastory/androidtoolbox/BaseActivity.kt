package com.turastory.androidtoolbox

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.turastory.androidtoolbox.configurable.ActionBarConfigurable
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (this) {
            is ActionBarConfigurable -> {
                supportActionBar?.title = actionBarName
            }
        }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}