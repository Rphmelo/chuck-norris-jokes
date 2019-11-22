package com.rphmelo.cnjokes.jokes.data.repository

import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesRepository @Inject
constructor(private val jokesService: JokesService) {

    fun getCategories(): Observable<List<String>> {
        return jokesService.getCategories()
    }

    fun getCategoryRandomJoke(category: String): Observable<JokeResponse>{
        return jokesService.getCategoryRandomJoke(category)
    }
}