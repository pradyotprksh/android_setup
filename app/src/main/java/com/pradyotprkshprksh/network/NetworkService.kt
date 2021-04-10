package com.pradyotprkshprksh.network

import com.pradyotprkshprksh.home.presenter.models.Todo
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("5a8e5b372f000048004f25fc")
    fun getTodoList() : Call<List<Todo>>
}