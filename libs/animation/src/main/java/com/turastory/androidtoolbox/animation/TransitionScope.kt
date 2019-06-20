package com.turastory.androidtoolbox.animation

import `in`.arunkumarsampath.transitionx.transition.set.TransitionSetBuilder
import android.view.ViewGroup
import androidx.transition.AutoTransition
import androidx.transition.Transition
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet

typealias TransitionBuilder =
    TransitionSetBuilder<TransitionSet>.() -> Unit

/**
 * Provide scope for transitions.
 */
class TransitionScope internal constructor(
    private val sceneRoot: ViewGroup
) {
    private fun prepare(
        builder: TransitionBuilder = {}
    ): Transition {
        return TransitionSetBuilder<TransitionSet>(AutoTransition())
            .apply(builder).transition
            .apply { TransitionManager.beginDelayedTransition(sceneRoot, this) }
    }
}

fun on(sceneRoot: ViewGroup, modifications: TransitionScope.() -> Unit): TransitionScope =
    TransitionScope(sceneRoot).apply(modifications)

operator fun ViewGroup.invoke(modifications: TransitionScope.() -> Unit): TransitionScope =
    on(this, modifications)