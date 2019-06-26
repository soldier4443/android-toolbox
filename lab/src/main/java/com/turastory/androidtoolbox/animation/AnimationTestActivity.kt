package com.turastory.androidtoolbox.animation

import android.os.Bundle
import com.airbnb.lottie.LottieDrawable
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.ActivityAnimationTestBinding
import com.turastory.androidtoolbox.databinding.bind
import com.turastory.androidtoolbox.ext.preventMultipleEmission

class AnimationTestActivity : RxBaseActivity(), TestBase {

    override val actionBarName: String
        get() = "Animation"

    private lateinit var binding: ActivityAnimationTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_animation_test)
        binding.frontLottie.repeatCount = LottieDrawable.INFINITE

        +binding.animateButton
            .clicks()
            .preventMultipleEmission()
            .subscribe({
                binding.frontView.fade()
            }, Throwable::printStackTrace)

        +binding.animateSecondButton
            .clicks()
            .preventMultipleEmission()
            .subscribe({
                binding.frontSecondView.fade()
            }, Throwable::printStackTrace)
    }
}