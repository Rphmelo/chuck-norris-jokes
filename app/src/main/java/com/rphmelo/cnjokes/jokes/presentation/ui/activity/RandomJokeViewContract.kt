package com.rphmelo.cnjokes.jokes.presentation.ui.activity

import com.rphmelo.cnjokes.common.base.BaseViewContract
import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse

interface RandomJokeViewContract : BaseViewContract {
    fun fillRandomJoke(jokeResponse: JokeResponse)
}