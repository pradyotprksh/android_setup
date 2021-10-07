package com.pradyotprkshprksh.network

import com.pradyotprkshprksh.network.models.Quotes
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("v1/quotes")
    fun getRandomQuote(): Call<List<Quotes>>
}