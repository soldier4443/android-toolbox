package com.turastory.androidtoolbox.animation

import android.view.View
import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.turastory.androidtoolbox.core.gone
import com.turastory.androidtoolbox.core.visible

fun View.fade(
    delay: Long = VISIBLE_DELAY,
    lazy: Boolean = false
): AdditiveAnimator {
    visible()
    alpha = 0f
    return AdditiveAnimator.animate(this)
        .alpha(1f)
        .thenWithDelay(delay)
        .alpha(0f)
        .addEndAction {
            gone()
        }
        .apply {
            if (!lazy) start()
        }
}

fun View.fadeWithFadeVisiblity(
    delay: Long = VISIBLE_DELAY,
    lazy: Boolean = false
): AdditiveAnimator {
    return AdditiveAnimator.animate(this)
        .fadeVisibility(View.VISIBLE)
        .thenWithDelay(delay)
        .fadeVisibility(View.GONE)
        .apply {
            if (!lazy) start()
        }
}

fun View.fadeWith(
    lottie: LottieAnimationView,
    minimumDelay: Long = VISIBLE_DELAY,
    lazy: Boolean = false
): AdditiveAnimator {
    if (lottie.repeatCount == LottieDrawable.INFINITE)
        lottie.repeatCount = 0

    val delay = Math.max(lottie.duration, minimumDelay)

    visible()
    alpha = 0f
    return AdditiveAnimator.animate(this)
        .addStartAction {
            lottie.playAnimation()
        }
        .alpha(1f)
        .thenWithDelay(delay)
        .alpha(0f)
        .addEndAction {
            gone()
        }
        .apply {
            if (!lazy) start()
        }
}