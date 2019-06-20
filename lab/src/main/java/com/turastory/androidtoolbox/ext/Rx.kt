package com.turastory.androidtoolbox.ext

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun <T> Observable<T>.preventMultipleEmission(): Observable<T> =
    throttleFirst(300, TimeUnit.MILLISECONDS)