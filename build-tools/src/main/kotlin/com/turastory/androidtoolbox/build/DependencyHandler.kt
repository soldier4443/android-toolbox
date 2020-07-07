package com.turastory.androidtoolbox.build

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

/**
 * DependencyHandler extensions for common dependencies
 */

fun DependencyHandler.kotlinJvm(version: String) = kotlin("stdlib-jdk8", version)
fun DependencyHandler.kotlinReflect(version: String) = kotlin("reflect", version)

fun DependencyHandler.junit(version: String) = "junit:junit:${version}"

fun DependencyHandler.rxJava(version: String) = "io.reactivex.rxjava2:rxjava:${version}"
fun DependencyHandler.rxKotlin(version: String) = "io.reactivex.rxjava2:rxkotlin:${version}"
fun DependencyHandler.rxAndroid(version: String) = "io.reactivex.rxjava2:rxandroid:${version}"

fun DependencyHandler.rxBinding(module: String? = null, version: String): String =
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
