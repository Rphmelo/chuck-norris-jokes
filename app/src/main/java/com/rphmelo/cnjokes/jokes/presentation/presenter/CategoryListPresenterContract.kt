package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListViewContract

interface CategoryListPresenterContract {

    fun attachView(categoryListViewContract: CategoryListViewContract)
    fun showErrorMessage(message: String)
    fun getCategories()
    fun fillCategoryList(categoryList: List<String>)
    fun disposeObservable()
}