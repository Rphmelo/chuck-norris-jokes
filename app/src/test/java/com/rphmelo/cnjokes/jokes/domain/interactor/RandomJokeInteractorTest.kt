package com.rphmelo.cnjokes.jokes.domain.interactor

import com.rphmelo.cnjokes.jokes.data.repository.JokesRepository
import com.rphmelo.cnjokes.jokes.presentation.presenter.RandomJokePresenterContract
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.*

@RunWith(JUnit4::class)
class RandomJokeInteractorTest {

    @Mock
    private lateinit var randomJokePresenter: RandomJokePresenterContract

    @Mock
    private lateinit var jokesRepository: JokesRepository

    private var randomJokeInteractor: RandomJokeInteractorContract? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        randomJokeInteractor = RandomJokeInteractor(jokesRepository)
    }

}