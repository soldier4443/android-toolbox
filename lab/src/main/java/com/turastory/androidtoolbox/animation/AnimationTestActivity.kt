package com.turastory.androidtoolbox.animation

import android.os.Bundle
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.configurable.TestBase

class AnimationTestActivity : RxBaseActivity(), TestBase {

    override val actionBarName: String
        get() = "Animation Test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}