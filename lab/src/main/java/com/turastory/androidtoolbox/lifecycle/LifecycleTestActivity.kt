package com.turastory.androidtoolbox.lifecycle

import android.os.Bundle
import androidx.lifecycle.observe
import com.turastory.androidtoolbox.BaseRxBindingActivity
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.LayoutLifecycleTestBinding
import com.turastory.androidtoolbox.lifecycle.LifecycleTestViewModel.State

class LifecycleTestActivity : BaseRxBindingActivity<LayoutLifecycleTestBinding>(), TestBase {

    override val actionBarName: String
        get() = "Lifecycle"

    private val vm by lazy { getViewModel<LifecycleTestViewModel>() }

    override fun provideBinding(savedInstanceState: Bundle?): LayoutLifecycleTestBinding =
        LayoutLifecycleTestBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        use()
        observe()
    }

    private fun use() {
        var state by vm.state

        binding.incrementButton.setOnClickListener {
            state = State(state.count + 1)
        }
    }

    private fun observe() {
        vm.state.observe(this) { state ->
            binding.counterText.text = getString(R.string.counter_text, state.count)
        }
    }
}
