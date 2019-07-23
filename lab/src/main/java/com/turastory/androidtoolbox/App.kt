package com.turastory.androidtoolbox

import android.app.Application
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.Builder()
            .setFontAttrId(R.attr.fontPath)
            .build()
            .also {
                CalligraphyConfig.initDefault(it)
            }
    }
}