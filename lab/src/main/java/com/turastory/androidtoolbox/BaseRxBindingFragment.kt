package com.turastory.androidtoolbox

import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseRxBindingFragment<B : ViewBinding> : BaseBindingFragment<B>() {

    protected val disposables = CompositeDisposable()

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
