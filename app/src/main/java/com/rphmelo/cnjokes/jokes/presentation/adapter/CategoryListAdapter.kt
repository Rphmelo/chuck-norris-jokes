package com.rphmelo.cnjokes.jokes.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rphmelo.cnjokes.R
import com.rphmelo.cnjokes.common.extension.bind
import com.rphmelo.cnjokes.jokes.presentation.ui.activity.CategoryListViewContract
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryListAdapter @Inject constructor(
    private val categoryListViewContract: CategoryListViewContract
): RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {

    private var categoryList: List<String>

    init {
        categoryList = listOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_category_list, parent, false)
        return CategoryListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        categoryList[position].let {
            holder.bindView(it)
        }
    }

    fun updateCategoryList(categoryList: List<String>){
        this.categoryList = categoryList
    }

    inner class CategoryListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val textViewCategory: TextView by itemView.bind(R.id.text_view_category_name)

        fun bindView(category: String) {
            textViewCategory.text = category

            itemView.setOnClickListener{
                categoryListViewContract.launchRandomJoke(category)
            }
        }

    }
}