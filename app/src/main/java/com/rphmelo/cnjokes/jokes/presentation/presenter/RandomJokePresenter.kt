package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.jokes.domain.interactor.RandomJokeInteractorContract
import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.RandomJokeViewContract
import javax.inject.Inject

class RandomJokePresenter @Inject constructor(
    private var randomJokeInteractorContract: RandomJokeInteractorContract
) : RandomJokePresenterContract {

    private var randomJokeViewContract: RandomJokeViewContract? = null

    init {
        randomJokeInteractorContract.attachPresenter(this)
    }

    override fun attachView(randomJokeViewContract: RandomJokeViewContract) {
        this.randomJokeViewContract = randomJokeViewContract
    }

    override fun getRandomJoke(category: String) {
        randomJokeViewContract?.startLoading()
        randomJokeInteractorContract.getRandomJoke(category)
    }

    override fun fillRandomJoke(jokeResponse: JokeResponse) {
        randomJokeViewContract?.apply {
            stopLoading()
            fillRandomJoke(jokeResponse)
        }
    }

    override fun disposeObservable() {
        randomJokeInteractorContract.disposeObservable()
    }

    override fun showErrorMessage(message: String) {
        randomJokeViewContract?.apply {
            stopLoading()
            showErrorMessage(message)
        }
    }

}