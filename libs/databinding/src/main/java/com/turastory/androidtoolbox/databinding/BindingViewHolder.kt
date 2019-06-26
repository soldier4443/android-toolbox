package com.turastory.androidtoolbox.databinding

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindingViewHolder<B : ViewDataBinding>(
    protected val binding: B
) : RecyclerView.ViewHolder(binding.root) {
    val context: Context
        get() = itemView.context
}