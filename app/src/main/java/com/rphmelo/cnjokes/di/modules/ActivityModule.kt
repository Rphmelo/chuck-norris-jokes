package com.rphmelo.cnjokes.di.modules

import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListActivity
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.RandomJokeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeCategoryListActivity(): CategoryListActivity

    @ContributesAndroidInjector
    internal abstract fun contributeRandomJokeActivity(): RandomJokeActivity
}