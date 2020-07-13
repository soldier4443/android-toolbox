package com.turastory.androidtoolbox.databinding

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

fun <T : ViewDataBinding> FragmentActivity.bind(@LayoutRes layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}

fun <T : ViewDataBinding> T.withLifecycleOwner(lifecycleOwner: LifecycleOwner) = also { binding ->
    binding.lifecycleOwner = lifecycleOwner
}

fun <T : ViewBinding> T.withLifecycleOwner(lifecycleOwner: LifecycleOwner): T = apply {
    if (this is ViewDataBinding) withLifecycleOwner(lifecycleOwner)
}
