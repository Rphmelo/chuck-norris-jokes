package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.jokes.domain.interactor.CategoryListInteractorContract
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListViewContract
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryListPresenter @Inject constructor(
    private var categoryListInteractor: CategoryListInteractorContract
) : CategoryListPresenterContract {

    private var categoryListViewContract: CategoryListViewContract? = null

    init {
        categoryListInteractor.attachPresenter(this)
    }

    override fun attachView(categoryListViewContract: CategoryListViewContract){
        this.categoryListViewContract = categoryListViewContract
    }

    override fun getCategories() {
        categoryListViewContract?.startLoading()
        categoryListInteractor.getCategories()
    }

    override fun fillCategoryList(categoryList: List<String>) {
        categoryListViewContract?.apply {
            stopLoading()
            fillCategoryList(categoryList)
        }
    }

    override fun showErrorMessage(message: String) {
        categoryListViewContract?.apply {
            stopLoading()
            showErrorMessage(message)
        }
    }

    override fun disposeObservable() {
        categoryListInteractor.disposeObservable()
    }
}