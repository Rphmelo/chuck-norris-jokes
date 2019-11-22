package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.common.base.BasePresenterContract
import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.RandomJokeViewContract

interface RandomJokePresenterContract : BasePresenterContract {
    fun attachView(randomJokeViewContract: RandomJokeViewContract)
    fun getRandomJoke(category: String)
    fun fillRandomJoke(jokeResponse: JokeResponse)
}