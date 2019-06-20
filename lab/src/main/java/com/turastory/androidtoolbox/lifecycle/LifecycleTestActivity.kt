package com.turastory.androidtoolbox.lifecycle

import android.os.Bundle
import androidx.lifecycle.observe
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.ActivityLifecycleTestBinding
import com.turastory.androidtoolbox.databinding.bind
import com.turastory.androidtoolbox.lifecycle.LifecycleTestViewModel.State

class LifecycleTestActivity : RxBaseActivity(), TestBase {

    override val actionBarName: String
        get() = "Lifecycle"

    private val vm by lazy { getViewModel<LifecycleTestViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityLifecycleTestBinding>(R.layout.activity_lifecycle_test)
        use(binding)
        observe(binding)
    }

    private fun use(binding: ActivityLifecycleTestBinding) {
        var state by vm.state

        binding.incrementButton.setOnClickListener {
            state = State(state.count + 1)
        }
    }

    private fun observe(binding: ActivityLifecycleTestBinding) {
        vm.state.observe(this) { state ->
            binding.counterText.text = getString(R.string.counter_text, state.count)
        }
    }
}
