package com.pradyotprkshprksh.home.presenter

import com.pradyotprkshprksh.home.HomeContract

/**
 * Home presenter which will handle our presenter or the business logic of our
 * home module.
 *
 * @param view : The view part of our home module to update the view from our presenter layer.
 */
class HomePresenter(private var view: HomeContract.View?) : HomeContract.Presenter {
    override fun start() {

    }

    override fun stop() {

    }
}