package com.turastory.androidtoolbox.build

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

val DependencyHandler.kotlinJvm
    get() = kotlin("stdlib-jdk8", Version.kotlin)

val DependencyHandler.kotlinReflect
    get() = kotlin("reflect", Version.kotlin)

val DependencyHandler.junit
    get() = "junit:junit:${Version.junit}"

val DependencyHandler.rxJava: String
    get() = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"

val DependencyHandler.rxAndroid: String
    get() = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"

fun DependencyHandler.rxBinding(
    module: String? = null,
    version: String = Version.rxBinding
): String =
    "com.jakewharton.rxbinding3:rxbinding${optionalModule(module)}:$version"

fun DependencyHandler.kotlinx(module: String, version: String? = null): Any =
    "org.jetbrains.kotlinx:kotlinx-$module${optionalVersion(version)}"

fun DependencyHandler.androidx(artifact: String, module: String? = null, version: String): Any =
    "androidx.$artifact:$artifact${optionalModule(module)}:$version"

fun DependencyHandler.archCore(module: String, version: String): Any =
    "androidx.arch.core:core-$module:$version"

private fun optionalModule(module: String?) = module?.let { "-$module" } ?: ""

private fun optionalVersion(version: String?) = version?.let { ":$version" } ?: ""
