package com.turastory.androidtoolbox.build

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

val DependencyHandler.kotlinJvm
    get() = kotlin("stdlib-jdk8", Version.kotlin)

val DependencyHandler.junit
    get() = "junit:junit:${Version.junit}"

fun DependencyHandler.kotlinx(module: String, version: String? = null): Any =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

fun DependencyHandler.androidx(artifact: String, module: String? = null, version: String): Any =
    "androidx.$artifact:$artifact${module?.let { "-$module" } ?: ""}:$version"
