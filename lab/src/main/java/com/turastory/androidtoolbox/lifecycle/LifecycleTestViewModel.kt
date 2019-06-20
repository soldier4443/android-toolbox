package com.turastory.androidtoolbox.lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LifecycleTestViewModel : ViewModel() {

    class State(
        val count: Int
    )

    val state = MutableLiveData<State>(State(count = 0))

}