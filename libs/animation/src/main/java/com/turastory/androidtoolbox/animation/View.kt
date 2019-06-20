package com.turastory.androidtoolbox.animation

import android.view.View
import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator
import at.wirecube.additiveanimations.additive_animator.AnimationEndListener
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

fun View.fade(delay: Long = 1000L) {
    visibility = View.VISIBLE
    alpha = 0f
    AdditiveAnimator.animate(this)
        .alpha(1f)
        .thenWithDelay(delay)
        .alpha(0f)
        .addEndAction(object : AnimationEndListener() {
            override fun onAnimationEnd(wasCancelled: Boolean) {
                visibility = View.GONE
            }
        })
        .start()
}

fun View.fadeWith(
    lottie: LottieAnimationView,
    minimumDelay: Long = 1000L
) {
    if (lottie.repeatCount == LottieDrawable.INFINITE)
        lottie.repeatCount = 0

    val delay = Math.max(lottie.duration, minimumDelay)

    visibility = View.VISIBLE
    alpha = 0f
    AdditiveAnimator.animate(this)
        .addStartAction {
            lottie.playAnimation()
        }
        .alpha(1f)
        .thenWithDelay(delay)
        .alpha(0f)
        .addEndAction(object : AnimationEndListener() {
            override fun onAnimationEnd(wasCancelled: Boolean) {
                visibility = View.GONE
            }
        })
        .start()
}