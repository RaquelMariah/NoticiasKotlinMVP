package com.ramaria.aplicativonoticiaskotlin.services

import com.ramaria.aplicativonoticiaskotlin.model.ResponseNews
import com.ramaria.aplicativonoticiaskotlin.utils.Constants
import retrofit2.Response
import retrofit2.http.*


interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "br",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY



    ): Response<ResponseNews>

    @GET("/v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<ResponseNews>
}