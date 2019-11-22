package com.rphmelo.cnjokes.common.base

interface BaseViewContract {
    fun startLoading()
    fun stopLoading()
    fun showErrorMessage(message: String)
}