package com.ramaria.aplicativonoticiaskotlin.presenter.search

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews

interface SearchHome {

    interface Presenter{
        fun search(term: String)
        fun onSuccess(newsResponseNews: ResponseNews)
        fun onError(message: String)
        fun onComplete()
    }
}