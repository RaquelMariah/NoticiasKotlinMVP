package com.ramaria.aplicativonoticiaskotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramaria.aplicativonoticiaskotlin.R
import com.ramaria.aplicativonoticiaskotlin.adapter.MainAdapter
import com.ramaria.aplicativonoticiaskotlin.model.Article
import com.ramaria.aplicativonoticiaskotlin.model.data.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome
import com.ramaria.aplicativonoticiaskotlin.presenter.news.NewsPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy{
        MainAdapter()
    }

    private lateinit var presenter: NewsPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {

        val dataSource = NewsDataSource()
        presenter = NewsPresenter(this, dataSource)
        presenter.requestAll()
        configRecycler()
        clickAdapter()
    }

    private fun configRecycler(){
        with(rvNews){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(
                this@MainActivity, DividerItemDecoration.VERTICAL
            ))
        }
    }

    private fun clickAdapter(){
        mainAdapter.setOnClickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("article", article)
            startActivity(intent)
        }
    }

    override fun showPorgressBar() {

        rvProgressBar.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
    rvProgressBar.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
    mainAdapter.differ.submitList(articles.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search_menu -> {
                Intent(this, SearchActivity::class.java).apply{
                    startActivity(this)
                }
            }
            R.id.favorites_menu -> {
                Intent(this, FavoriteActivity::class.java).apply{
                    startActivity(this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}