package com.turastory.androidtoolbox.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class InfiniteAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    companion object {
        const val loopCount = 1000
        const val itemCount = 4
    }

    override fun getItem(position: Int): Fragment {
        return when (position % itemCount) {
            in (0 until itemCount) -> DummyFragment()
            else -> throw IllegalStateException("Impossible position")
        }
    }

    override fun getCount(): Int {
        return itemCount * loopCount
    }
}