package com.ramaria.aplicativonoticiaskotlin.presenter

import com.ramaria.aplicativonoticiaskotlin.model.Article

interface ViewHome {

    interface View{
        fun showPorgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showArticles(articles: List<Article>)
    }
}