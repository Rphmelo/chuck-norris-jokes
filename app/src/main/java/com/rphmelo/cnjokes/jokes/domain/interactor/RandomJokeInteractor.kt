package com.rphmelo.cnjokes.jokes.domain.interactor

import com.rphmelo.cnjokes.jokes.data.repository.JokesRepository
import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import com.rphmelo.cnjokes.jokes.presentation.presenter.RandomJokePresenterContract
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RandomJokeInteractor @Inject constructor(
    private var jokesRepository: JokesRepository
) : RandomJokeInteractorContract {

    private lateinit var randomJokePresenter: RandomJokePresenterContract

    private var disposable: Disposable? = null

    override fun attachPresenter(presenter: RandomJokePresenterContract) {
        randomJokePresenter = presenter
    }

    override fun getRandomJoke(category: String) {
        jokesRepository.getCategoryRandomJoke(category)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<JokeResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(jokeResponse: JokeResponse) {
                    randomJokePresenter.fillRandomJoke(jokeResponse)
                }

                override fun onError(e: Throwable) {
                    disposable = null

                    var message =  "Ocorreu um erro!"

                    e.message?.let {
                        message = it
                    }

                    randomJokePresenter.showErrorMessage(message)
                }
            })
    }

    override fun disposeObservable() {
        disposable?.dispose()
    }
}