package com.turastory.androidtoolbox.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SimpleAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            in (0..3) -> DummyFragment()
            else -> throw IllegalStateException("Impossible position")
        }
    }

    override fun getCount(): Int {
        return 4
    }
}