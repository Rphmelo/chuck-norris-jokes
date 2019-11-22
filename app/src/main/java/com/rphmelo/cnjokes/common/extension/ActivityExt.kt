package com.rphmelo.cnjokes.common.extension

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

fun <T : View> Activity.bind(@IdRes idRes: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(idRes) }
}