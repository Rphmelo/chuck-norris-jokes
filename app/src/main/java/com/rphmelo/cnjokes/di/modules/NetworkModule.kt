package com.rphmelo.cnjokes.di.modules

import android.app.Application
import com.google.gson.Gson
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun providePicasso(okHttp3Downloader: OkHttp3Downloader, app: Application): Picasso {
        return Picasso.Builder(app.applicationContext)
            .downloader(okHttp3Downloader)
            .build()
    }

    @Provides
    @Singleton
    fun okHttp3Downloader(okHttpClientBuilder: OkHttpClient.Builder): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClientBuilder.build())
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        @Named("apiUrl") apiUrl: String,
        okhttp: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(apiUrl)
            .client(okhttp)
            .build()
    }

    @Provides
    @Singleton
    @Named("apiUrl")
    fun provideApiURL(): String {
        return "https://api.chucknorris.io/jokes/"
    }
}