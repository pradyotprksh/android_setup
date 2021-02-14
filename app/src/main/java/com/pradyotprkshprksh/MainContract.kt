package com.pradyotprkshprksh

/**
 * The common contract methods which will be handle by our views and presenter in all our our
 * modules.
 */
interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun start()
        fun stop()
    }

    interface Presenter  {
        fun start()
        fun stop()
    }
}