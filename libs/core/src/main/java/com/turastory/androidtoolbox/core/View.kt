package com.turastory.androidtoolbox.core

import android.view.View

val View.isVisible
    get() = visibility == View.VISIBLE

val View.isGone
    get() = visibility == View.GONE

val View.isInvisible
    get() = visibility == View.INVISIBLE

val View.isHidden
    get() = isGone || isInvisible

fun View.visible(cond: Boolean = true, gone: Boolean = true) {
    visibility = when {
        cond -> View.VISIBLE
        gone -> View.GONE
        else -> View.INVISIBLE
    }
}

fun View.gone(cond: Boolean = true) =
    visible(!cond)

fun View.invisible(cond: Boolean = true) =
    visible(!cond, gone = false)
