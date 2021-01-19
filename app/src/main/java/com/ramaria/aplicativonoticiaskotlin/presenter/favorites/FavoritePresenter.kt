package com.ramaria.aplicativonoticiaskotlin.presenter.favorites

import com.ramaria.aplicativonoticiaskotlin.model.Article
import com.ramaria.aplicativonoticiaskotlin.model.database.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome

class FavoritePresenter (
    val view: ViewHome.Favorite,
    private val dataSource: NewsDataSource): FavoriteHome.Presenter{

    fun getAll(){
     this.dataSource.getAllArticle(this)
    }

    fun saveArticle(article: Article){
        this.dataSource.saveArticle(article)
    }

    override fun onSuccess(articles: List<Article>) {
        this.view.showArticles(articles)
    }
}