package com.rphmelo.cnjokes.di.modules

import com.rphmelo.cnjokes.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeJokesListActivity(): MainActivity

}