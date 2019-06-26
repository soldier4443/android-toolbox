package com.turastory.androidtoolbox.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.turastory.androidtoolbox.R
import com.turastory.androidtoolbox.RxBaseActivity
import com.turastory.androidtoolbox.animation.TransitionTestAdapter.ViewHolder
import com.turastory.androidtoolbox.base.ModelListener
import com.turastory.androidtoolbox.base.PositionedModelListener
import com.turastory.androidtoolbox.configurable.TestBase
import com.turastory.androidtoolbox.databinding.ActivityRvTransitionTestBinding
import com.turastory.androidtoolbox.databinding.BindingViewHolder
import com.turastory.androidtoolbox.databinding.LayoutSimpleItemBinding
import com.turastory.androidtoolbox.databinding.bind

class RecyclerViewTransitionActivity : RxBaseActivity(), TestBase {
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

    private val transitionTestAdapter = TransitionTestAdapter { position, _ ->
        toggleItem(position)
    }

    private fun toggleItem(position: Int) {
        val item = items[position]
        items[position] = item.copy(active = item.active.not())
        transitionTestAdapter.submitList(items.toList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRvTransitionTestBinding = bind(R.layout.activity_rv_transition_test)

        with(binding.recyclerView) {
            adapter = transitionTestAdapter
            layoutManager = LinearLayoutManager(this@RecyclerViewTransitionActivity)
        }

        transitionTestAdapter.submitList(items)
    }
}

data class TransitionTestModel(
    val id: Int,
    val active: Boolean
)

class TransitionTestAdapter(private val listener: PositionedModelListener<TransitionTestModel>) :
    ListAdapter<TransitionTestModel, ViewHolder>(diff) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<LayoutSimpleItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_simple_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)) { model ->
            listener(position, model)
        }
    }

    class ViewHolder(binding: LayoutSimpleItemBinding) :
        BindingViewHolder<LayoutSimpleItemBinding>(binding) {

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