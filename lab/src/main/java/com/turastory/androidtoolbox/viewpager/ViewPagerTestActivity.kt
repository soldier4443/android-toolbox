package com.turastory.androidtoolbox.viewpager

import android.os.Bundle
import com.turastory.androidtoolbox.BaseRxBindingActivity
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.LayoutViewPagerTestBinding

/**
 * Test async data loading + update within view pager
 */
class ViewPagerTestActivity : BaseRxBindingActivity<LayoutViewPagerTestBinding>(), TestBase {

    override val actionBarName: String
        get() = "ViewPager"

    override fun provideBinding(savedInstanceState: Bundle?): LayoutViewPagerTestBinding =
        LayoutViewPagerTestBinding.inflate(layoutInflater)

    private val simpleAdapter by lazy { InfiniteAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            viewPager.adapter = simpleAdapter
            viewPager.currentItem = InfiniteAdapter.loopCount / 2
        }
    }
}