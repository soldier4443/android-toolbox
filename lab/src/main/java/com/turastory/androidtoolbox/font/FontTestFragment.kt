package com.turastory.androidtoolbox.font

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.turastory.androidtoolbox.BaseBindingFragment
import com.turastory.androidtoolbox.databinding.LayoutFontTestBinding

class FontTestFragment : BaseBindingFragment<LayoutFontTestBinding>() {
    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutFontTestBinding = LayoutFontTestBinding.inflate(inflater)
}