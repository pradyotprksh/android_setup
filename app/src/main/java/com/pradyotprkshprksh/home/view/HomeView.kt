package com.pradyotprkshprksh.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pradyotprkshprksh.R
import com.pradyotprkshprksh.home.HomeContract
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
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun start() {

    }

    override fun stop() {

    }
}