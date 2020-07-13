package com.turastory.androidtoolbox.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.turastory.androidtoolbox.base.app.BaseRxBindingFragment
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.LayoutViewPagerTestBinding

/**
 * Test async data loading + update within view pager
 */
class ViewPagerTestFragment : BaseRxBindingFragment<LayoutViewPagerTestBinding>(), TestBase {

    override val actionBarName: String
        get() = "ViewPager"

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutViewPagerTestBinding = LayoutViewPagerTestBinding.inflate(layoutInflater)

    private val simpleAdapter by lazy { InfiniteAdapter(childFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            viewPager.adapter = simpleAdapter
            viewPager.currentItem = InfiniteAdapter.loopCount / 2
        }
    }
}