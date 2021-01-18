package com.ramaria.aplicativonoticiaskotlin.presenter.search

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews
import com.ramaria.aplicativonoticiaskotlin.model.data.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome

class SearchPresenter( val view: ViewHome.View,
private val dataSource: NewsDataSource): SearchHome.Presenter {
    override fun search(term: String) {
        this.view.showPorgressBar()
        this.dataSource.searchNews(term, this)
    }

    override fun onSuccess(newsResponseNews: ResponseNews) {
        this.view.showArticles(newsResponseNews.articles)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)

    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }

}
