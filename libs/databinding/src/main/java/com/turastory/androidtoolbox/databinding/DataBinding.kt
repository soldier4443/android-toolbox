package com.turastory.androidtoolbox.databinding

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity

fun <T : ViewDataBinding> FragmentActivity.bind(@LayoutRes layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}
