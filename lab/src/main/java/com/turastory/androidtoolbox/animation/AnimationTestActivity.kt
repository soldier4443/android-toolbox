package com.turastory.androidtoolbox.animation

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.airbnb.lottie.LottieDrawable
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.BaseRxBindingActivity
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.LayoutAnimationTestBinding
import com.turastory.androidtoolbox.ext.preventMultipleEmission

class AnimationTestActivity : BaseRxBindingActivity<LayoutAnimationTestBinding>(), TestBase {

    override val actionBarName: String
        get() = "Animation"

    override fun provideBinding(savedInstanceState: Bundle?): LayoutAnimationTestBinding =
        LayoutAnimationTestBinding.inflate(layoutInflater)

    private fun fadeInAnimation(target: View, duration: Long) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.alpha_0_to_1)
        animation.duration = duration

        target.apply {
            visibility = View.VISIBLE
            clearAnimation()
            setAnimation(animation)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.frontLottie.repeatCount = LottieDrawable.INFINITE

        +binding.animateButton
            .clicks()
            .preventMultipleEmission()
            .subscribe({
                binding.frontView.visibility = View.VISIBLE
                fadeInAnimation(binding.frontView, 500L)
            }, Throwable::printStackTrace)

        +binding.animateSecondButton
            .clicks()
            .preventMultipleEmission()
            .subscribe({
                binding.frontSecondView.fade()
            }, Throwable::printStackTrace)
    }
}