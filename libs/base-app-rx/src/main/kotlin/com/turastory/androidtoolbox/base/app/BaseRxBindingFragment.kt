package com.turastory.androidtoolbox.base.app

import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseRxBindingFragment<B : ViewBinding> : BaseBindingFragment<B>(), RxEffect {

    private val disposables = CompositeDisposable()

    override fun disposables(): CompositeDisposable = disposables

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}
