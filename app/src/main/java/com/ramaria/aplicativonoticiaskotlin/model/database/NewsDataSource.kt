package com.ramaria.aplicativonoticiaskotlin.model.database

import android.content.Context
import com.ramaria.aplicativonoticiaskotlin.model.Article
import com.ramaria.aplicativonoticiaskotlin.presenter.favorites.FavoriteHome
import com.ramaria.aplicativonoticiaskotlin.presenter.search.SearchHome
import com.ramaria.aplicativonoticiaskotlin.services.NewsHome
import com.ramaria.aplicativonoticiaskotlin.services.RetrofitInstance
import kotlinx.coroutines.*

class NewsDataSource (context: Context){

    private var db: ArticleDataBase = ArticleDataBase(context)
    private var newsRepository: NewsRepository = NewsRepository(db)

    fun getBreakingNews(callback: NewsHome.Presenter){

        GlobalScope.launch (Dispatchers.Main  ){
          val response =  RetrofitInstance.api.getBreakingNews("br")
            if(response.isSuccessful){
                response.body()?.let {newsResponse ->
                    callback.onSuccess(newsResponse)
                }
                callback.onComplete()
            }else{
                callback.onError(response.message())
                callback.onComplete()
            }

        }
    }

    fun searchNews(term: String, callback: SearchHome.Presenter){
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.searchNews(term)
            if(response.isSuccessful){
                response.body()?.let { responseNews ->
                    callback.onSuccess(responseNews)
                }
                callback.onComplete()
            }else{
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

    fun saveArticle(article: Article){
      GlobalScope.launch (Dispatchers.Main) {
          newsRepository.updateInsert(article)
      }
    }

    fun getAllArticle(callback: FavoriteHome){
        var allArticles: List<Article>
        CoroutineScope(Dispatchers.IO).launch {
            allArticles = newsRepository.getAll()
            withContext(Dispatchers.Main){
                callback.showArticles(allArticles)
            }
        }
    }

    fun deleteArticle(article: Article?){
        GlobalScope.launch(Dispatchers.Main){
            article?.let{
                articleSafe ->
                newsRepository.delete(articleSafe)
            }
        }

    }
}