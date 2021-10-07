package com.pradyotprkshprksh.home

import com.pradyotprkshprksh.MainContract

/**
 * Different contracts followed by our home module for the view and presenter layer.
 */
interface HomeContract {
    interface View : MainContract.View {
        fun setQuote(quote: String, author: String)
    }

    interface Presenter : MainContract.Presenter {

    }
}