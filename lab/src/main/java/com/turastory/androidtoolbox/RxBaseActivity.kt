package com.turastory.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxBaseActivity : AppCompatActivity() {

    private val disposables = CompositeDisposable()

    protected operator fun Disposable.unaryPlus() {
        disposables.add(this)
    }

    protected fun Disposable.disposedBy(
        compositeDisposable: CompositeDisposable = disposables
    ) {
        compositeDisposable.add(this)
    }

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}