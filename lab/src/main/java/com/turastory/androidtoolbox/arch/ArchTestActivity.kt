package com.turastory.androidtoolbox.arch

import android.os.Bundle
import android.util.Log
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.databinding.ActivityArchTestBinding
import com.turastory.androidtoolbox.databinding.bind
import com.turastory.androidtoolbox.ext.preventMultipleEmission

class ArchTestActivity : RxBaseActivity() {

    private lateinit var binding: ActivityArchTestBinding
    private val base = Base(disposables)
    private val shotgunAddon = ShotgunAddon(base)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_arch_test)

        +binding.shotButton.clicks()
            .preventMultipleEmission()
            .map { ShotgunAddon.Intent.PullTrigger }
            .subscribe({
                shotgunAddon.accept(it)
            }, Throwable::printStackTrace)

        shotgunAddon
            .forUi()
            .subscribe { state ->
                renderShotButton(state.reloading)
                renderShotResult(state.shotResult)
                renderLogPanel(state.logText)
            }
    }

    private fun renderShotButton(reloading: Boolean) = with(binding.shotButton) {
        isEnabled = !reloading
        text = if (reloading) "Reloading..." else "Shot!"
    }

    private fun renderShotResult(shotResult: String) = with(binding.resultText) {
        text = shotResult
    }

    private fun renderLogPanel(logText: String) = with(binding.logPanel) {
        text = logText
    }

    override fun onDestroy() {
        super.onDestroy()
        base.sweep()
    }
}