package com.ramaria.aplicativonoticiaskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramaria.aplicativonoticiaskotlin.R
import com.ramaria.aplicativonoticiaskotlin.adapter.MainAdapter
import com.ramaria.aplicativonoticiaskotlin.model.Article
import com.ramaria.aplicativonoticiaskotlin.model.data.NewsDataSource
import com.ramaria.aplicativonoticiaskotlin.presenter.ViewHome
import com.ramaria.aplicativonoticiaskotlin.presenter.search.SearchPresenter
import com.ramaria.aplicativonoticiaskotlin.utils.UtilQueryTextListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter

    override fun getLayout(): Int = R.layout.activity_search

    override fun onInject() {

        val dataSource = NewsDataSource()
        presenter = SearchPresenter(this, dataSource)
        configRecycler()
        search()

    }

    private fun search(){
        searchNews.setOnQueryTextListener(
                UtilQueryTextListener(
                        this.lifecycle
                ){
                    newText -> newText?.let{
                    query ->
                    if(query.isNotEmpty()){
                        presenter.search(query)
                        rvProgressBarSearch.visibility = View.VISIBLE
                    }
                }
                }
        )
    }

    private fun configRecycler(){
        with(rvSearch){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(DividerItemDecoration(
                    this@SearchActivity, DividerItemDecoration.VERTICAL
            ))
        }
    }

    override fun showPorgressBar() {
        rvProgressBarSearch.visibility = View.VISIBLE

    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}