package com.ramaria.aplicativonoticiaskotlin.presenter.news

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews
import com.ramaria.aplicativonoticiaskotlin.model.database.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome
import com.ramaria.aplicativonoticiaskotlin.services.NewsHome

class NewsPresenter (val view: ViewHome.View,
private val dataSource: NewsDataSource
) : NewsHome.Presenter  {
    override fun requestAll() {
    this.view.showPorgressBar()
        this.dataSource.getBreakingNews(this)
    }

    override fun onSuccess(newsResponse: ResponseNews) {
    this.view.showArticles(newsResponse.articles)
    }

    override fun onError(message: String) {
    this.view.showFailure(message)
    }

    override fun onComplete() {
    this.view.hideProgressBar()
    }


}