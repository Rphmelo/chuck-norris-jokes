package com.rphmelo.cnjokes.common.base

interface BasePresenterContract {
    fun disposeObservable()
    fun showErrorMessage(message: String)
}