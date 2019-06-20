package com.turastory.androidtoolbox.lifecycle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

inline fun <reified VM : ViewModel> Fragment.getViewModel() =
    ViewModelProviders.of(this)[VM::class.java]

inline fun <reified VM : ViewModel> FragmentActivity.getViewModel() =
    ViewModelProviders.of(this)[VM::class.java]
