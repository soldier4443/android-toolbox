package com.turastory.androidtoolbox.arch

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Source of shot results
 */
class Shotgun {

    private val dummyResults = listOf(
        "KILL",
        "MISS"
    )

    fun shot(): Observable<String> {
        return Observable.just(dummyResults.random())
            .subscribeOn(Schedulers.io())
            .delay(1000, TimeUnit.MILLISECONDS, Schedulers.io())
    }

    fun reload(): Observable<Unit> {
        return Observable.just(Unit)
            .subscribeOn(Schedulers.io())
            .delay(2000, TimeUnit.MILLISECONDS, Schedulers.io())
    }
}