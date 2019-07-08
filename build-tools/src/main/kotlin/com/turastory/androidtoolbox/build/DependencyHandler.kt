package com.turastory.androidtoolbox.build

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

/**
 * DependencyHandler extensions for common dependencies
 */

val DependencyHandler.kotlinJvm
    get() = kotlin("stdlib-jdk8", CommonVersions.kotlin)

val DependencyHandler.kotlinReflect
    get() = kotlin("reflect", CommonVersions.kotlin)

val DependencyHandler.junit
    get() = "junit:junit:${CommonVersions.junit}"

val DependencyHandler.rxJava: String
    get() = "io.reactivex.rxjava2:rxjava:${CommonVersions.rxJava}"

val DependencyHandler.rxAndroid: String
    get() = "io.reactivex.rxjava2:rxandroid:${CommonVersions.rxAndroid}"

fun DependencyHandler.rxBinding(
    module: String? = null,
    version: String = CommonVersions.rxBinding
): String =
    "com.jakewharton.rxbinding3:rxbinding${optionalModule(module)}:$version"

fun DependencyHandler.kotlinx(module: String, version: String? = null): Any =
    "org.jetbrains.kotlinx:kotlinx-$module${optionalVersion(version)}"

fun DependencyHandler.androidx(artifact: String, module: String? = null, version: String): Any =
    "androidx.$artifact:$artifact${optionalModule(module)}:$version"

fun DependencyHandler.archCore(module: String, version: String): Any =
    "androidx.arch.core:core-$module:$version"

fun DependencyHandler.material(version: String): Any =
    "com.google.android.material:material:$version"

private fun optionalModule(module: String?) = module?.let { "-$module" } ?: ""

private fun optionalVersion(version: String?) = version?.let { ":$version" } ?: ""
