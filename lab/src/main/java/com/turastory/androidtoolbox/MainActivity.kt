package com.turastory.androidtoolbox

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.turastory.androidtoolbox.base.app.BaseBindingActivity
import com.turastory.androidtoolbox.databinding.LayoutMainBinding


class MainActivity : BaseBindingActivity<LayoutMainBinding>() {

    private val onDestinationChangedListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.title = destination.label
        }

    override fun provideBinding(savedInstanceState: Bundle?): LayoutMainBinding =
        LayoutMainBinding.inflate(layoutInflater)

    override fun onStart() {
        super.onStart()

        supportFragmentManager.primaryNavigationFragment?.findNavController()?.run {
            removeOnDestinationChangedListener(onDestinationChangedListener)
            addOnDestinationChangedListener(onDestinationChangedListener)
        }
    }
}
