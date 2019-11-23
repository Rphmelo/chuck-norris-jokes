package com.rphmelo.cnjokes.jokes.presentation.presenter

import com.rphmelo.cnjokes.jokes.domain.interactor.CategoryListInteractorContract
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListViewContract
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class CategoryListPresenterTest {

    private lateinit var categoryListPresenter: CategoryListPresenterContract

    @Mock
    private var categoryListInteractor: CategoryListInteractorContract? = null

    @Mock
    private lateinit var categoryListViewContract: CategoryListViewContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        categoryListInteractor?.apply {
            categoryListPresenter = CategoryListPresenter(this)
            categoryListPresenter.attachView(categoryListViewContract)
        }
    }

    @Test
    fun fillCategoryList() {
        Assert.assertNotNull(categoryListPresenter)
        val categories: List<String> = listOf("dev", "science")

        categoryListPresenter.attachView(categoryListViewContract)
        categoryListPresenter.fillCategoryList(categories)

        Mockito.verify(categoryListViewContract, Mockito.atLeastOnce())?.stopLoading()
        Mockito.verify(categoryListViewContract, Mockito.atLeastOnce())?.fillCategoryList(categories)
    }

    @Test
    fun getCategories() {
        Assert.assertNotNull(categoryListPresenter)

        categoryListPresenter.attachView(categoryListViewContract)
        categoryListPresenter.getCategories()

        Mockito.verify(categoryListViewContract, Mockito.atLeastOnce())?.startLoading()
        Mockito.verify(categoryListInteractor, Mockito.atLeastOnce())?.getCategories()
    }

    @Test
    fun disposeObservable() {
        Assert.assertNotNull(categoryListPresenter)

        categoryListPresenter.attachView(categoryListViewContract)
        categoryListPresenter.disposeObservable()

        Mockito.verify(categoryListInteractor, Mockito.atLeastOnce())?.disposeObservable()
    }

    @Test
    fun showErrorMessage() {
        Assert.assertNotNull(categoryListPresenter)

        categoryListPresenter.attachView(categoryListViewContract)
        categoryListPresenter.showErrorMessage("")

        Mockito.verify(categoryListViewContract, Mockito.atLeastOnce())?.stopLoading()
        Mockito.verify(categoryListViewContract, Mockito.atLeastOnce())?.showErrorMessage("")
    }
}