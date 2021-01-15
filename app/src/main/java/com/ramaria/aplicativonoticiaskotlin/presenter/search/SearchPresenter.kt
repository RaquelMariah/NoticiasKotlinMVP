package com.ramaria.aplicativonoticiaskotlin.presenter.search

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews
import com.ramaria.aplicativonoticiaskotlin.model.data.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome

class SearchPresenter( val view: ViewHome.View,
private val dataSource: NewsDataSource): SearchHome.Presenter {
    override fun search(term: String) {

    }

    override fun onSuccess(newsResponseNews: ResponseNews) {

    }

    override fun onError(message: String) {

    }

    override fun onComplete() {

    }

}
