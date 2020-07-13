package com.turastory.androidtoolbox.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.turastory.androidtoolbox.base.app.BaseBindingFragment
import com.turastory.androidtoolbox.databinding.LayoutDummyBinding

class DummyFragment : BaseBindingFragment<LayoutDummyBinding>() {

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutDummyBinding = LayoutDummyBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = words.random()
    }
}