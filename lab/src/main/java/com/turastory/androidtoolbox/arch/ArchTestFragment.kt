package com.turastory.androidtoolbox.arch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.BaseRxBindingFragment
import com.turastory.androidtoolbox.databinding.LayoutArchTestBinding
import com.turastory.androidtoolbox.ext.preventMultipleEmission

class ArchTestFragment : BaseRxBindingFragment<LayoutArchTestBinding>() {

    private val base = Base(disposables)
    private val shotgunAddon = ShotgunAddon(base)

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutArchTestBinding = LayoutArchTestBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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