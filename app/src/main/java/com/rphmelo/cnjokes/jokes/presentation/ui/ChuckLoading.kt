package com.rphmelo.cnjokes.jokes.presentation.ui

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.widget.FrameLayout
import com.rphmelo.cnjokes.R

object ChuckLoading {

    private var dialog: Dialog? = null

    fun create(activity: Activity) {
        dialog = Dialog(activity, R.style.Chuck_Loading)
        dialog?.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            ownerActivity = activity
            setContentView(R.layout.view_chuck_loading)
            setCancelable(false)
        }

        val window = dialog?.window

        window?.apply {
            attributes.windowAnimations = R.style.Chuck_Loading
            setLayout(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    fun show(activity: Activity) {
        create(activity)
        dialog?.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}