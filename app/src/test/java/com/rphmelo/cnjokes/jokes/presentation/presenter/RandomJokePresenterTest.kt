package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.jokes.domain.interactor.RandomJokeInteractorContract
import com.rphmelo.cnjokes.jokes.domain.model.JokeResponse
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.RandomJokeViewContract
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class RandomJokePresenterTest {

    private lateinit var randomJokePresenter: RandomJokePresenterContract

    @Mock
    private var randomJokeInteractor: RandomJokeInteractorContract? = null

    @Mock
    private lateinit var randomJokeView: RandomJokeViewContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        randomJokeInteractor?.apply {
            randomJokePresenter = RandomJokePresenter(this)
            randomJokePresenter.attachView(randomJokeView)
        }
    }

    @Test
    fun fillRandomJoke() {
        Assert.assertNotNull(randomJokePresenter)
        val randomJoke = JokeResponse("", "", "", "")

        randomJokePresenter.attachView(randomJokeView)
        randomJokePresenter.fillRandomJoke(randomJoke)

        Mockito.verify(randomJokeView, Mockito.atLeastOnce())?.stopLoading()
        Mockito.verify(randomJokeView, Mockito.atLeastOnce())?.fillRandomJoke(randomJoke)
    }

    @Test
    fun getRandomJoke() {
        Assert.assertNotNull(randomJokePresenter)

        randomJokePresenter.attachView(randomJokeView)
        randomJokePresenter.getRandomJoke("")

        Mockito.verify(randomJokeView, Mockito.atLeastOnce())?.startLoading()
        Mockito.verify(randomJokeInteractor, Mockito.atLeastOnce())?.getRandomJoke("")
    }

    @Test
    fun disposeObservable() {
        Assert.assertNotNull(randomJokePresenter)

        randomJokePresenter.attachView(randomJokeView)
        randomJokePresenter.disposeObservable()

        Mockito.verify(randomJokeInteractor, Mockito.atLeastOnce())?.disposeObservable()
    }

    @Test
    fun showErrorMessage() {
        Assert.assertNotNull(randomJokePresenter)

        randomJokePresenter.attachView(randomJokeView)
        randomJokePresenter.showErrorMessage("")

        Mockito.verify(randomJokeView, Mockito.atLeastOnce())?.stopLoading()
        Mockito.verify(randomJokeView, Mockito.atLeastOnce())?.showErrorMessage("")
    }
}