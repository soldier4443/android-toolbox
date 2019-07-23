package com.turastory.androidtoolbox.font

import android.os.Bundle
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.databinding.ActivityFontTestBinding
import com.turastory.androidtoolbox.databinding.bind

class FontTestActivity : RxBaseActivity() {

    private lateinit var binding: ActivityFontTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_font_test)
    }
}