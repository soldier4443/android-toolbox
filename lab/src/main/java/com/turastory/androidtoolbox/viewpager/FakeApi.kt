package com.turastory.androidtoolbox.viewpager

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS
import kotlin.random.Random

class FakeApi {
    fun loadMessage(): Observable<String> {
        // Mock random delay for network
        val delay = Random.nextLong(0, 2000)

        return Observable
            .timer(delay, MILLISECONDS)
            .map { words.random() }
    }
}