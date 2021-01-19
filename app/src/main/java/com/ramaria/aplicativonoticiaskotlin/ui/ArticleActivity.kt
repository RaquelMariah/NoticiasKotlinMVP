package com.ramaria.aplicativonoticiaskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.google.android.material.snackbar.Snackbar
import com.ramaria.aplicativonoticiaskotlin.R
import com.ramaria.aplicativonoticiaskotlin.model.Article
import com.ramaria.aplicativonoticiaskotlin.model.database.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome
import com.ramaria.aplicativonoticiaskotlin.presenter.favorites.FavoritePresenter
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AbstractActivity(), ViewHome.Favorite     {

    private lateinit var article: Article
    private lateinit var presenter: FavoritePresenter

    override fun getLayout(): Int =
        R.layout.activity_article

    override fun onInject() {
        getArticle()
        val dataSource = NewsDataSource(this)
        presenter = FavoritePresenter(this, dataSource)

        webView.apply{
            webViewClient = WebViewClient()
            article.url?.let{ url ->
                loadUrl(url)
            }
        }

        fabArticle.setOnClickListener{
            presenter.saveArticle(article)
            Snackbar.make(it, R.string.article_saved_successful, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get("article") as Article
        }
    }

    override fun showArticles(articles: List<Article>) {
        TODO("Not yet implemented")
    }
}