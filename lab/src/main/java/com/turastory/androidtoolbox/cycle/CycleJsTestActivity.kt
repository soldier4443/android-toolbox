package com.turastory.androidtoolbox.cycle

import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.databinding.ActivityCycleJsTestBinding
import com.turastory.androidtoolbox.databinding.bind
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class CycleJsTestActivity : RxBaseActivity() {

    private val counter = AtomicInteger(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityCycleJsTestBinding>(
            R.layout.activity_cycle_js_test
        )

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
