package com.turastory.androidtoolbox.animation

import androidx.transition.Transition

typealias TransitionListener =
        (Transition) -> Unit

fun Transition.addListener(
    onStart: TransitionListener? = null,
    onResume: TransitionListener? = null,
    onCancel: TransitionListener? = null,
    onPause: TransitionListener? = null,
    onEnd: TransitionListener? = null
) {
    val listener = object : Transition.TransitionListener {
        override fun onTransitionStart(transition: Transition) {
            onStart?.invoke(transition)
        }

        override fun onTransitionResume(transition: Transition) {
            onResume?.invoke(transition)
        }

        override fun onTransitionCancel(transition: Transition) {
            onCancel?.invoke(transition)
        }

        override fun onTransitionPause(transition: Transition) {
            onPause?.invoke(transition)
        }

        override fun onTransitionEnd(transition: Transition) {
            onEnd?.invoke(transition)
        }
    }

    addListener(listener)
}