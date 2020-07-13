package com.turastory.androidtoolbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.turastory.androidtoolbox.DestinationAdapter.ViewHolder
import com.turastory.androidtoolbox.databinding.BaseBindingViewHolder
import com.turastory.androidtoolbox.databinding.ItemDestinationBinding
import com.turastory.androidtoolbox.databinding.withLifecycleOwner

class DestinationAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val onClickDestination: (Int) -> Unit = {}
) : ListAdapter<Destination, ViewHolder>(provideDiff()) {
    companion object {
        fun provideDiff() = object : ItemCallback<Destination>() {
            override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean =
                oldItem.actionId == newItem.actionId

            override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ItemDestinationBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)
        .withLifecycleOwner(lifecycleOwner)
        .let(::ViewHolder)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClickDestination)
    }

    class ViewHolder(binding: ItemDestinationBinding) :
        BaseBindingViewHolder<ItemDestinationBinding>(binding) {
        fun bind(
            item: Destination,
            onClickDestination: (Int) -> Unit
        ) {
            binding.text.text = item.name.substringBeforeLast("Fragment")
            binding.root.setOnClickListener { onClickDestination(item.actionId) }
        }
    }
}
