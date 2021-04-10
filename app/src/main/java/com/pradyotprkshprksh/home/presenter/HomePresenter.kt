package com.pradyotprkshprksh.home.presenter

import android.util.Log
import com.pradyotprkshprksh.home.HomeContract
import com.pradyotprkshprksh.home.presenter.models.Todo
import com.pradyotprkshprksh.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

/**
 * Home presenter which will handle our presenter or the business logic of our
 * home module.
 *
 * @param view : The view part of our home module to update the view from our presenter layer.
 */
class HomePresenter(private var view: HomeContract.View?) : HomeContract.Presenter {
    override fun start() {
        getTheToDoList()
    }

    override fun stop() {

    }

    /**
     * Get the list of todos from the api
     */
    private fun getTheToDoList() {
        view?.showLoading()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(NetworkService::class.java)
        val call = service.getTodoList();

        call.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>?, response: Response<List<Todo>>?) {
                view?.hideLoading()
                val todos = response?.body()
                if (todos != null) {
                    val pendingTodos: ArrayList<Todo> = ArrayList<Todo>()
                    val completedTodos: ArrayList<Todo> = ArrayList<Todo>()

                    for (todo in todos) {
                        if (todo.status == "PENDING") {
                            pendingTodos.add(todo)
                        } else {
                            completedTodos.add(todo)
                        }
                    }

                    view?.updateTodoList(pendingTodos, completedTodos)
                }
            }

            override fun onFailure(call: Call<List<Todo>>?, t: Throwable?) {
                view?.hideLoading()
            }
        })
    }
}