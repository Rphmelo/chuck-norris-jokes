package com.rphmelo.cnjokes.common.base

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

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
}