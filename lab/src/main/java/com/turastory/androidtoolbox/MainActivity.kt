package com.turastory.androidtoolbox

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.turastory.androidtoolbox.databinding.ActivityMainBinding
import com.turastory.androidtoolbox.databinding.bind
import kotlin.reflect.KClass


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityMainBinding>(R.layout.activity_main)

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
