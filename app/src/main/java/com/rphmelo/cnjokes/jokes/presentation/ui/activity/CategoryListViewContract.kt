package com.rphmelo.cnjokes.jokes.presentation.ui.activity

import com.rphmelo.cnjokes.common.base.BaseViewContract

interface CategoryListViewContract : BaseViewContract {
    fun launchRandomJoke(category: String)
    fun fillCategoryList(categoryList: List<String>)
}