package com.pradyotprkshprksh.home.presenter

import com.pradyotprkshprksh.home.HomeContract
import com.pradyotprkshprksh.network.NetworkService
import com.pradyotprkshprksh.network.models.Quotes
import com.pradyotprkshprksh.utility.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Home presenter which will handle our presenter or the business logic of our
 * home module.
 *
 * @param view : The view part of our home module to update the view from our presenter layer.
 */
class HomePresenter(
    private var view: HomeContract.View?,
    private val networkService: NetworkService
) : HomeContract.Presenter {
    override fun start() {
        getRandomQuote()
    }

    private fun getRandomQuote() {
        view?.showLoading()
        try {
            networkService.getRandomQuote().enqueue(object : Callback<List<Quotes>> {
                override fun onResponse(
                    call: Call<List<Quotes>>?,
                    response: Response<List<Quotes>>?
                ) {
                    view?.hideLoading()
                    if (response != null) {
                        val quotes = response.body()
                        if (quotes != null) {
                            view?.setQuote(quotes.first().quote, quotes.first().author)
                        }
                    }
                }

                override fun onFailure(call: Call<List<Quotes>>?, t: Throwable?) {
                    view?.hideLoading()
                }
            })
        } catch (e: Exception) {
            view?.hideLoading()
            Utility.printMessage(e.toString())
        }
    }

    override fun stop() {

    }
}