package com.ramaria.aplicativonoticiaskotlin.services

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews

interface NewsHome {

    interface Presenter{
        fun requestAll()
        fun onSuccess(newsResponse: ResponseNews)
        fun onError(message: String)
        fun onComplete()
    }
}