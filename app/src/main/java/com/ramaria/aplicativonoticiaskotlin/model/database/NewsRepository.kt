package com.ramaria.aplicativonoticiaskotlin.model.database

import com.ramaria.aplicativonoticiaskotlin.model.Article

class NewsRepository (private val db: ArticleDataBase) {

    suspend fun updateInsert(article: Article) = db.getArticleDao().updateInsert(article)

    fun getAll(): List<Article> = db.getArticleDao().getAll()

    suspend fun delete(article: Article) = db.getArticleDao().delete(article)

}