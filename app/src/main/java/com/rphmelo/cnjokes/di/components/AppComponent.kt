package com.rphmelo.cnjokes.di.components

import android.app.Application
import com.rphmelo.cnjokes.MyApplication
import com.rphmelo.cnjokes.di.modules.ActivityModule
import com.rphmelo.cnjokes.di.modules.AppModule
import com.rphmelo.cnjokes.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    NetworkModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MyApplication)
}