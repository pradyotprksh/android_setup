package com.pradyotprkshprksh.di

import com.pradyotprkshprksh.home.HomeContract
import com.pradyotprkshprksh.home.presenter.HomePresenter
import org.koin.dsl.module.module

/**
 * Application module of our project which will be used for injecting
 * different modules used in different part of our project.
 */
val applicationModule = module(override = true) {
    factory<HomeContract.Presenter> { (view: HomeContract.View) -> HomePresenter(view) }
}