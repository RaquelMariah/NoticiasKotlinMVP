package com.ramaria.aplicativonoticiaskotlin.presenter.favorites

import com.ramaria.aplicativonoticiaskotlin.model.Article

interface FavoriteHome {
    fun showArticles(articles: List<Article>)
}