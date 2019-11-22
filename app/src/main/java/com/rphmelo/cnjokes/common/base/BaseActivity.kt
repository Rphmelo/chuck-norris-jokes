package com.rphmelo.cnjokes.common.base

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.rphmelo.cnjokes.common.helper.DialogHelper
import com.rphmelo.cnjokes.jokes.presentation.ui.ChuckLoading
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseViewContract {

    protected fun displayToolbarHomeButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    protected fun setTitleToolbar(titleToolbar: String) {
        supportActionBar?.title = titleToolbar
    }

    protected fun configureDagger() {
        AndroidInjection.inject(this)
    }

    override fun startLoading() {
        ChuckLoading.show(this)
    }

    override fun stopLoading() {
        ChuckLoading.dismiss()
    }

    override fun showErrorMessage(message: String) {
        DialogHelper.showMessageDialog(this, message)
    }
}