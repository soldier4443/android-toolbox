package com.turastory.androidtoolbox.databinding

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseBindingViewHolder<B : ViewBinding>(
    protected val binding: B
) : RecyclerView.ViewHolder(binding.root) {
    val context: Context
        get() = itemView.context
}