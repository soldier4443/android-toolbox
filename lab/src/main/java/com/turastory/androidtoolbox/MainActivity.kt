package com.turastory.androidtoolbox

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.turastory.androidtoolbox.databinding.ActivityMainBinding
import kotlin.reflect.KClass


class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun provideBinding(savedInstanceState: Bundle?): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.list.adapter = MainListAdapter { kClass ->
            startActivity(Intent(this, kClass.java))
        }
    }

    private inner class MainListAdapter(private val onClickItem: (KClass<*>) -> Unit) :
        BaseAdapter() {
        private val items: List<KClass<*>> = testTargets

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: layoutInflater.inflate(
                android.R.layout.simple_list_item_1,
                parent,
                false
            )

            view.findViewById<TextView>(android.R.id.text1)?.let { textView ->
                textView.text = getItem(position).simpleName
            }

            view.setOnClickListener {
                onClickItem(getItem(position))
            }

            return view
        }

        override fun getItem(position: Int): KClass<*> = items[position]

        override fun getItemId(position: Int): Long = items[position].hashCode().toLong()

        override fun getCount(): Int = items.size
    }
}
