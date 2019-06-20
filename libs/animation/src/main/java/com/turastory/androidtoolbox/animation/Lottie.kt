package com.turastory.androidtoolbox.animation

import android.animation.Animator
import com.airbnb.lottie.LottieAnimationView

typealias AnimatorListener =
        (Animator) -> Unit

fun LottieAnimationView.addListener(
    onRepeat: AnimatorListener? = null,
    onEnd: AnimatorListener? = null,
    onCancel: AnimatorListener? = null,
    onStart: AnimatorListener? = null
) {
    val listener = object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animator: Animator) {
            onRepeat?.invoke(animator)
        }

        override fun onAnimationEnd(animator: Animator) {
            onEnd?.invoke(animator)
        }

        override fun onAnimationCancel(animator: Animator) {
            onCancel?.invoke(animator)
        }

        override fun onAnimationStart(animator: Animator) {
            onStart?.invoke(animator)
        }

    }
    addAnimatorListener(listener)
}