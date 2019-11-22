package com.rphmelo.cnjokes

import android.app.Activity
import android.content.Intent
import com.rphmelo.cnjokes.common.AppConstant
import com.rphmelo.cnjokes.common.AppConstant.JOKE_CATEGORY_CODE
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListActivity
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.RandomJokeActivity

class AppRouter {

    companion object {

        fun launchCategoryListActivity(source: Activity) {
            val intent = Intent(source, CategoryListActivity::class.java)
            source.startActivity(intent)
        }

        fun launchRandomJokeActivity(source: Activity, category: String) {
            val intent = Intent(source, RandomJokeActivity::class.java)
            intent.putExtra(JOKE_CATEGORY_CODE, category)
            source.startActivity(intent)
        }

    }
}