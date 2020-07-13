package com.turastory.androidtoolbox.base.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.turastory.androidtoolbox.databinding.withLifecycleOwner

abstract class BaseBindingActivity<B : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = provideBinding(savedInstanceState).withLifecycleOwner(this)
        setContentView(binding.root)
    }

    abstract fun provideBinding(savedInstanceState: Bundle?): B
}