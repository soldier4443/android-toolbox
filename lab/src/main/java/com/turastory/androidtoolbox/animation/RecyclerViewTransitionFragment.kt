package com.turastory.androidtoolbox.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.turastory.androidtoolbox.BaseRxBindingFragment
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.animation.TransitionTestAdapter.ViewHolder
import com.turastory.androidtoolbox.base.ModelListener
import com.turastory.androidtoolbox.base.PositionedModelListener
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.BaseBindingViewHolder
import com.turastory.androidtoolbox.databinding.LayoutRvTransitionTestBinding
import com.turastory.androidtoolbox.databinding.LayoutSimpleItemBinding
import com.turastory.androidtoolbox.databinding.withLifecycleOwner

class RecyclerViewTransitionFragment :
    BaseRxBindingFragment<LayoutRvTransitionTestBinding>(),
    TestBase {

    override val actionBarName: String
        get() = "RecyclerView Transition"

    private val items = mutableListOf(
        TransitionTestModel(1, true),
        TransitionTestModel(2, false),
        TransitionTestModel(3, true),
        TransitionTestModel(4, false),
        TransitionTestModel(5, false),
        TransitionTestModel(6, true)
    )

    private val transitionTestAdapter = TransitionTestAdapter(viewLifecycleOwner) { position, _ ->
        toggleItem(position)
    }

    private fun toggleItem(position: Int) {
        val item = items[position]
        items[position] = item.copy(active = item.active.not())
        transitionTestAdapter.submitList(items.toList())
    }

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LayoutRvTransitionTestBinding = LayoutRvTransitionTestBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding.recyclerView) {
            adapter = transitionTestAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        transitionTestAdapter.submitList(items)
    }
}

data class TransitionTestModel(
    val id: Int,
    val active: Boolean
)

class TransitionTestAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val listener: PositionedModelListener<TransitionTestModel>
) : ListAdapter<TransitionTestModel, ViewHolder>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<TransitionTestModel>() {
            override fun areItemsTheSame(
                oldItem: TransitionTestModel,
                newItem: TransitionTestModel
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: TransitionTestModel,
                newItem: TransitionTestModel
            ): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutSimpleItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .withLifecycleOwner(lifecycleOwner)
            .let(::ViewHolder)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)) { model ->
            listener(position, model)
        }
    }

    class ViewHolder(binding: LayoutSimpleItemBinding) :
        BaseBindingViewHolder<LayoutSimpleItemBinding>(binding) {

        fun bind(model: TransitionTestModel, listener: ModelListener<TransitionTestModel>) {
            binding.text.text = "${model.id}"
            binding.card.background = if (model.active) {
                context.getDrawable(R.drawable.bg_white_round_8dp)
            } else {
                context.getDrawable(R.drawable.bg_black_round_8dp)
            }

            binding.card.setOnClickListener { listener(model) }
        }
    }
}