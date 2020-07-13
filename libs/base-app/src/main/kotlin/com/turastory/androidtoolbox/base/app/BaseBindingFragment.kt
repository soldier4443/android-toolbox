package com.turastory.androidtoolbox.base.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.turastory.androidtoolbox.databinding.withLifecycleOwner

abstract class BaseBindingFragment<B : ViewBinding> : Fragment() {

    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = provideBinding(inflater, container, savedInstanceState)
            .withLifecycleOwner(viewLifecycleOwner)
        return binding.root
    }

    abstract fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): B
}