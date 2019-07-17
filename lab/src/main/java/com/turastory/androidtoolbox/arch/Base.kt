package com.turastory.androidtoolbox.arch

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base for addons.
 *
 * Handles lifecycles of components
 */
class Base(private val disposables: CompositeDisposable) {
    fun add(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun sweep() {
        disposables.clear()
    }
}