package com.turastory.androidtoolbox.base.app

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface RxEffect {
    fun disposables(): CompositeDisposable

    operator fun Disposable.unaryPlus() {
        disposables().add(this)
    }

    fun Disposable.disposedBy(compositeDisposable: CompositeDisposable = disposables()) {
        compositeDisposable.add(this)
    }
}
