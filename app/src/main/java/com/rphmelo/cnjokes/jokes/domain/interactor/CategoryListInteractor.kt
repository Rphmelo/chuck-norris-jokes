package com.rphmelo.cnjokes.jokes.domain.interactor

import com.rphmelo.cnjokes.jokes.data.repository.JokesRepository
import com.rphmelo.cnjokes.jokes.presentation.presenter.CategoryListPresenterContract
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryListInteractor @Inject constructor(
    private var jokesRepository: JokesRepository
) : CategoryListInteractorContract {

    private lateinit var categoryListPresenter: CategoryListPresenterContract

    var disposable: Disposable? = null

    override fun attachPresenter(presenter: CategoryListPresenterContract) {
        categoryListPresenter = presenter
    }

    override fun getCategories() {
        jokesRepository.getCategories()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<List<String>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(categoryList: List<String>) {
                    categoryListPresenter.fillCategoryList(categoryList)
                }

                override fun onError(e: Throwable) {
                    disposable = null

                    var message =  "Ocorreu um erro!"

                    e.message?.let {
                        message = it
                    }

                    categoryListPresenter.showErrorMessage(message)
                }
            })
    }

    override fun disposeObservable() {
        disposable?.dispose()
    }

}
