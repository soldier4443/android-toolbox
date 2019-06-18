package com.turastory.androidtoolbox

import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

operator fun <T> MutableLiveData<T>.getValue(thisObj: Any?, property: KProperty<*>): MutableLiveData<T> = this

operator fun <T> MutableLiveData<T>.setValue(thisObj: Any?, property: KProperty<*>, next: T) {
    value = next
}