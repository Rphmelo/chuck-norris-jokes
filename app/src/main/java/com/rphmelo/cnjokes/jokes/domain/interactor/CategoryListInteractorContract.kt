package com.rphmelo.cnjokes.jokes.domain.interactor

import com.rphmelo.cnjokes.common.base.BaseInteractorContract
import com.rphmelo.cnjokes.jokes.presentation.presenter.CategoryListPresenterContract

interface CategoryListInteractorContract : BaseInteractorContract{
    fun getCategories()
    fun attachPresenter(presenter: CategoryListPresenterContract)
}