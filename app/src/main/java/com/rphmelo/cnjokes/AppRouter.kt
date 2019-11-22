package com.rphmelo.cnjokes

import android.app.Activity
import android.content.Intent
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListActivity

class AppRouter {

    companion object {

        fun launchCategoryListActivity(source: Activity) {
            val intent = Intent(source, CategoryListActivity::class.java)
            source.startActivity(intent)
        }

    }
}