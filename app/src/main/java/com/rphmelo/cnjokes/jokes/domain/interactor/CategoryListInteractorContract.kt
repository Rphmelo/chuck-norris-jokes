package com.rphmelo.cnjokes.jokes.domain.interactor

import com.rphmelo.cnjokes.jokes.presentation.presenter.CategoryListPresenterContract

interface CategoryListInteractorContract {
    fun getCategories()
    fun disposeObservable()
    fun attachPresenter(presenter: CategoryListPresenterContract)
}