package com.turastory.androidtoolbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.turastory.androidtoolbox.base.app.BaseBindingFragment
import com.turastory.androidtoolbox.databinding.LayoutHomeBinding

class HomeFragment : BaseBindingFragment<LayoutHomeBinding>() {
    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutHomeBinding = LayoutHomeBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDestinations.apply {
            adapter = DestinationAdapter(
                viewLifecycleOwner,
                findNavController()::navigate
            ).also { adapter ->
                adapter.submitList(getDestinations())
            }
        }
    }

    private fun getDestinations(): List<Destination> {
        val navController = findNavController()

        return navController.graph.iterator()
            .asSequence()
            .toList()
            .map { navDestination ->
                Destination(navDestination.label.toString(), navDestination.id)
            }
            .filter {
                it.name != navController.currentDestination?.label ?: "HomeFragment"
            }
    }
}