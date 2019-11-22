package com.rphmelo.cnjokes.di.modules

import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeCategoryListActivity(): CategoryListActivity
}