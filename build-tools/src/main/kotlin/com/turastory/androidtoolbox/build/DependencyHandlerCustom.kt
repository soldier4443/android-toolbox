package com.turastory.androidtoolbox.build

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.lottie(version: String) =
    "com.airbnb.android:lottie:$version"

val DependencyHandler.transitionx
    get() = "in.arunkumarsampath:transition-x:${Version.transition}"