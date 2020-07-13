package com.turastory.androidtoolbox.cycle

import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.BaseRxBindingActivity
import com.turastory.androidtoolbox.databinding.LayoutCycleJsTestBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class CycleJsTestActivity : BaseRxBindingActivity<LayoutCycleJsTestBinding>() {

    override fun provideBinding(savedInstanceState: Bundle?): LayoutCycleJsTestBinding =
        LayoutCycleJsTestBinding.inflate(layoutInflater)

    private val counter = AtomicInteger(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.incrementButton
            .clicks()
            .throttleFirst(300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.counterText.text = "${counter.addAndGet(1)}"
            }, Throwable::printStackTrace)
            .disposedBy()
    }
}
