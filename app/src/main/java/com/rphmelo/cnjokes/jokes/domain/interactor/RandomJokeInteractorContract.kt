package com.rphmelo.cnjokes.jokes.domain.interactor

import com.rphmelo.cnjokes.common.base.BaseInteractorContract
import com.rphmelo.cnjokes.jokes.presentation.presenter.RandomJokePresenterContract

interface RandomJokeInteractorContract : BaseInteractorContract {
    fun attachPresenter(presenter: RandomJokePresenterContract)
    fun getRandomJoke(category: String)
}