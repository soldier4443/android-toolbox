package com.turastory.androidtoolbox.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

operator fun <T> MutableLiveData<T>.setValue(
    t: Any?,
    property: KProperty<*>,
    next: T
) {
    this.value = next
}

operator fun <T> LiveData<T>.getValue(
    t: Any?,
    property: KProperty<*>
): T =
    this.value!!

fun <T> mutableLiveData(provider: () -> T): MutableLiveData<T> {
    return MutableLiveData(provider())
}