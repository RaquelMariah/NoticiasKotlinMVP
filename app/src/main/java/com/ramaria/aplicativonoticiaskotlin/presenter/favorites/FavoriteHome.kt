package com.ramaria.aplicativonoticiaskotlin.presenter.favorites

import com.ramaria.aplicativonoticiaskotlin.model.Article

interface FavoriteHome {
    interface Presenter{

        fun onSuccess(articles: List<Article>)
    }

}