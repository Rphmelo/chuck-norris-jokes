package com.rphmelo.cnjokes.common.extension

import android.support.annotation.IdRes
import android.view.View

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun <T : View> View.bind(@IdRes idRes: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(idRes) }
}