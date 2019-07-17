package com.turastory.androidtoolbox

import com.turastory.androidtoolbox.animation.AnimationTestActivity
import com.turastory.androidtoolbox.animation.RecyclerViewTransitionActivity
import com.turastory.androidtoolbox.arch.ArchTestActivity
import com.turastory.androidtoolbox.lifecycle.LifecycleTestActivity
import com.turastory.androidtoolbox.viewpager.ViewPagerTestActivity

val testTargets = listOf(
    ArchTestActivity::class,
    ViewPagerTestActivity::class,
    RecyclerViewTransitionActivity::class,
    LifecycleTestActivity::class,
    AnimationTestActivity::class
)
