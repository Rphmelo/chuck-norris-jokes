package com.rphmelo.cnjokes.jokes.presentation.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import com.rphmelo.cnjokes.AppRouter
import com.rphmelo.cnjokes.R
import com.rphmelo.cnjokes.common.base.BaseActivity
import com.rphmelo.cnjokes.common.helper.DialogHelper
import com.rphmelo.cnjokes.common.extension.bind
import com.rphmelo.cnjokes.common.extension.gone
import com.rphmelo.cnjokes.common.extension.visible
import com.rphmelo.cnjokes.jokes.presentation.adapter.CategoryListAdapter
import com.rphmelo.cnjokes.jokes.presentation.presenter.CategoryListPresenterContract
import javax.inject.Inject

class CategoryListActivity : BaseActivity(), CategoryListViewContract {

    private val recyclerCategoriesList: RecyclerView by bind(R.id.recycler_activity_categories_list)
    private val progressBar: ProgressBar by bind(R.id.progress_bar_category_list)

    private var categoryListAdapter: CategoryListAdapter = CategoryListAdapter(this)

    @Inject lateinit var categoryListPresenter: CategoryListPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        configureDagger()

        categoryListPresenter.attachView(this)

        setupRecyclerView()
    }

    override fun launchRandomJoke(category: String) {
        AppRouter.launchCategoryListActivity(this)
    }

    override fun fillCategoryList(categoryList: List<String>) {
        categoryListAdapter.updateCategoryList(categoryList)
        recyclerCategoriesList.adapter?.notifyDataSetChanged()
    }

    override fun startLoading() {
        recyclerCategoriesList.gone()
        progressBar.visible()
    }

    override fun stopLoading() {
        progressBar.gone()
        recyclerCategoriesList.visible()
    }

    override fun showErrorMessage(message: String) {
        DialogHelper.showMessageDialog(this, message)
    }

    private fun setupRecyclerView(){
        recyclerCategoriesList.layoutManager = LinearLayoutManager(applicationContext)
        recyclerCategoriesList.hasFixedSize()
        recyclerCategoriesList.adapter = categoryListAdapter

        categoryListPresenter.getCategories()
    }

    override fun onDestroy() {
        super.onDestroy()
        categoryListPresenter.disposeObservable()
    }

}
