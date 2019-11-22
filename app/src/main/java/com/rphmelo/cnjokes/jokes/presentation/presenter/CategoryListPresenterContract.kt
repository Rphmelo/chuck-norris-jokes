package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.common.base.BasePresenterContract
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListViewContract

interface CategoryListPresenterContract : BasePresenterContract {
    fun attachView(categoryListViewContract: CategoryListViewContract)
    fun getCategories()
    fun fillCategoryList(categoryList: List<String>)
}