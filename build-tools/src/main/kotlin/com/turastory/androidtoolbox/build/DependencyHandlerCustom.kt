package com.turastory.androidtoolbox.build

import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * DependencyHandler extensions for custom libraries
 */

fun DependencyHandler.lottie(version: String) =
    "com.airbnb.android:lottie:$version"

fun DependencyHandler.transitionx(version: String) =
    "in.arunkumarsampath:transition-x:$version"

fun DependencyHandler.calligraphy(version: String) =
    "uk.co.chrisjenx:calligraphy:$version"
