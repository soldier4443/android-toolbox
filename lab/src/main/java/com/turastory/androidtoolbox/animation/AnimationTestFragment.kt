package com.turastory.androidtoolbox.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.airbnb.lottie.LottieDrawable
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.base.app.BaseRxBindingFragment
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.LayoutAnimationTestBinding
import com.turastory.androidtoolbox.ext.preventMultipleEmission

class AnimationTestFragment : BaseRxBindingFragment<LayoutAnimationTestBinding>(), TestBase {

    override val actionBarName: String
        get() = "Animation"

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutAnimationTestBinding = LayoutAnimationTestBinding.inflate(layoutInflater)

    private fun fadeInAnimation(target: View, duration: Long) {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.alpha_0_to_1)
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