package com.rphmelo.cnjokes.di.modules

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rphmelo.cnjokes.jokes.data.repository.JokesRepository
import com.rphmelo.cnjokes.jokes.data.repository.JokesService
import com.rphmelo.cnjokes.jokes.domain.interactor.CategoryListInteractor
import com.rphmelo.cnjokes.jokes.domain.interactor.CategoryListInteractorContract
import com.rphmelo.cnjokes.jokes.domain.interactor.RandomJokeInteractor
import com.rphmelo.cnjokes.jokes.domain.interactor.RandomJokeInteractorContract
import com.rphmelo.cnjokes.jokes.presentation.presenter.CategoryListPresenter
import com.rphmelo.cnjokes.jokes.presentation.presenter.CategoryListPresenterContract
import com.rphmelo.cnjokes.jokes.presentation.presenter.RandomJokePresenter
import com.rphmelo.cnjokes.jokes.presentation.presenter.RandomJokePresenterContract
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideJokesService(retrofit: Retrofit): JokesService {
        return retrofit.create(JokesService::class.java)
    }

    @Provides
    @Singleton
    fun provideJokesRepository(
        jokesService: JokesService
    ): JokesRepository {
        return JokesRepository(jokesService)
    }

    @Provides
    @Singleton
    fun provideCategoryListInteractor(
        jokesRepository: JokesRepository
    ): CategoryListInteractorContract {
        return CategoryListInteractor(jokesRepository)
    }

    @Provides
    @Singleton
    fun provideCategoryListPresenter(
        categoryListInteractor: CategoryListInteractor
    ): CategoryListPresenterContract {
        return CategoryListPresenter(categoryListInteractor)
    }

    @Provides
    @Singleton
    fun provideRandomJokeInteractor(
        jokesRepository: JokesRepository
    ): RandomJokeInteractorContract {
        return RandomJokeInteractor(jokesRepository)
    }

    @Provides
    @Singleton
    fun provideRandomJokePresenter(
        randomJokeInteractor: RandomJokeInteractor
    ): RandomJokePresenterContract {
        return RandomJokePresenter(randomJokeInteractor)
    }
}