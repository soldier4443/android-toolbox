package com.turastory.androidtoolbox.arch

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

/**
 * Addon represents reusable, meaningful block of code that performs specific functionality.
 */
interface Addon<Intent, Effect, State> : Consumer<Intent>, ObservableSource<State> {
    val actor: Actor<Intent, Effect>
    val reducer: Reducer<Effect, State>
    val postProcessor: PostProcessor<State, Intent?>?
        get() = null

    fun Disposable.disposedBy(base: Base) {
        base.add(this)
    }

    fun subscribe(onNext: (State) -> Unit) {
        this.subscribe(object : Observer<State> {
            override fun onComplete() {}

            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: State) {
                onNext(t)
            }

            override fun onError(e: Throwable) {}
        })
    }
}

/**
 * Map intent of the user to effect - which affects the resulting state.
 */
typealias Actor<Intent, Effect> = (Intent) -> Observable<List<Effect>>

/**
 * Given state and effect, to make new, immutable state.
 */
typealias Reducer<Effect, State> = (Effect, State) -> State

typealias PostProcessor<State, Intent> = (Intent, State) -> Intent
