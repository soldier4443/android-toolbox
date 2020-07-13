package com.turastory.androidtoolbox

import androidx.annotation.IdRes

data class Destination(
    val name: String,
    @IdRes val actionId: Int
)
