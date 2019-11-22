package com.rphmelo.cnjokes.common.helper

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.rphmelo.cnjokes.R

object DialogHelper {

    fun showMessageDialog(context: Context, message: String) {
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog?.apply {
            setTitle(context.resources.getString(R.string.label_attention))
            setMessage(message)
            setCancelable(true)
            setButton(
                DialogInterface.BUTTON_POSITIVE, "OK"
            ) { _, _ -> dismiss() }
            show()
        }
    }
}