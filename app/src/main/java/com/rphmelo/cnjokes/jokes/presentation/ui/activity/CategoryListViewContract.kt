package com.rphmelo.cnjokes.jokes.presentation.ui.activity

interface CategoryListViewContract {

    fun launchRandomJoke(category: String)
    fun startLoading()
    fun stopLoading()
    fun fillCategoryList(categoryList: List<String>)
    fun showErrorMessage(message: String)
}