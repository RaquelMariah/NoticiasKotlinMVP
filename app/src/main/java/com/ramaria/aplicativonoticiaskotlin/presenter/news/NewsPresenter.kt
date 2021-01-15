package com.ramaria.aplicativonoticiaskotlin.presenter.news

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews
import com.ramaria.aplicativonoticiaskotlin.model.data.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome
import com.ramaria.aplicativonoticiaskotlin.services.NewsHome

class NewsPresenter (val view: ViewHome.View,
private val dataSource: NewsDataSource
) : NewsHome.Presenter  {
    override fun requestAll() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(newsResponse: ResponseNews) {
        TODO("Not yet implemented")
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }


}