package com.pradyotprkshprksh.home.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pradyotprkshprksh.R
import com.pradyotprkshprksh.home.HomeContract
import kotlinx.android.synthetic.main.view_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * The view part of our home module which will be used in initializing our views and
 * updating it based on the conditions or the needs.
 */
class HomeView : AppCompatActivity(), HomeContract.View {

    private val homePresenter: HomeContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_home)

        homePresenter.start()
    }

    override fun setQuote(quote: String, author: String) {
        runOnUiThread {
            authorTv.text = author
            quoteTv.text = quote
        }
    }

    override fun showLoading() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }
    }

    override fun hideLoading() {
        runOnUiThread {
            progressBar.visibility = View.GONE
        }
    }

    override fun start() {

    }

    override fun stop() {

    }
}