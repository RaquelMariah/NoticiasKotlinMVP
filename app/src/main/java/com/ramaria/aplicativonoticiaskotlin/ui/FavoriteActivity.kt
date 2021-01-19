package com.ramaria.aplicativonoticiaskotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramaria.aplicativonoticiaskotlin.R
import com.ramaria.aplicativonoticiaskotlin.adapter.MainAdapter
import com.ramaria.aplicativonoticiaskotlin.model.Article
import com.ramaria.aplicativonoticiaskotlin.model.database.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome
import com.ramaria.aplicativonoticiaskotlin.presenter.favorites.FavoritePresenter
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_main.*

class FavoriteActivity : AbstractActivity(), ViewHome.Favorite {

    private val mainAdapter by lazy{
        MainAdapter()
    }

    private lateinit var presenter: FavoritePresenter

    override fun getLayout(): Int = R.layout.activity_favorite

    override fun onInject() {

        val dataSource = NewsDataSource(this)
        presenter = FavoritePresenter(this, dataSource)
        presenter.getAll()
        configRecycler()
        clickAdapter()

    }

    private fun configRecycler(){
        with(rvFavorites){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            addItemDecoration(
                DividerItemDecoration(
                this@FavoriteActivity, DividerItemDecoration.VERTICAL
            )
            )
        }
    }

    private fun clickAdapter(){
        mainAdapter.setOnClickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("article", article)
            startActivity(intent)
        }
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}