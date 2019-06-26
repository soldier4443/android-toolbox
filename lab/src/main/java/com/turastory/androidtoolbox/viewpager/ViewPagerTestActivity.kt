package com.turastory.androidtoolbox.viewpager

import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.ActivityViewPagerTestBinding
import com.turastory.androidtoolbox.databinding.bind

/**
 * Test async data loading + update within view pager
 */
class ViewPagerTestActivity : RxBaseActivity(), TestBase {

    override val actionBarName: String
        get() = "ViewPager"

    private lateinit var binding: ActivityViewPagerTestBinding
    private val simpleAdapter by lazy { SimpleAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bind(R.layout.activity_view_pager_test)

        with(binding) {
            viewPager.adapter = simpleAdapter
        }
    }
}