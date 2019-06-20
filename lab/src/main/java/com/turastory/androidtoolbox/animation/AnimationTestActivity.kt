package com.turastory.androidtoolbox.animation

import `in`.arunkumarsampath.transitionx.prepareAutoTransition
import `in`.arunkumarsampath.transitionx.transitionSet
import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import android.view.View
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
                startTransition()
            }, Throwable::printStackTrace)
    }

    private fun startTransition() = with(binding) {
        prepareTransition()
        frontView.visibility = View.VISIBLE
        frontLottie.repeatCount = 0
        frontLottie.addAnimatorListener(object : AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                prepareTransition()
                frontView.visibility = View.GONE
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }
        })
        frontLottie.playAnimation()
    }

    private fun prepareTransition() = with(binding) {
        container.prepareAutoTransition {
            +frontView
        }
    }
}