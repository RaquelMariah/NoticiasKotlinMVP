package com.ramaria.aplicativonoticiaskotlin.model.database

import com.ramaria.aplicativonoticiaskotlin.presenter.search.SearchHome
import com.ramaria.aplicativonoticiaskotlin.services.NewsHome
import com.ramaria.aplicativonoticiaskotlin.services.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDataSource {

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

}