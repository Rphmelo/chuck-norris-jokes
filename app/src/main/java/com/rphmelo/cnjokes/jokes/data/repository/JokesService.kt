package com.rphmelo.cnjokes.jokes.data.repository

import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesService {
    @GET("categories")
    fun getCategories(): Observable<List<String>>

    @GET("random")
    fun getCategoryRandomJoke(
        @Query("category") category: String
    ): Observable<JokeResponse>
}