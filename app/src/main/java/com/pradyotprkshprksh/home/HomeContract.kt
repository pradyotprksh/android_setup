package com.pradyotprkshprksh.home

import com.pradyotprkshprksh.MainContract
import com.pradyotprkshprksh.home.presenter.models.Todo
import java.util.ArrayList

/**
 * Different contracts followed by our home module for the view and presenter layer.
 */
interface HomeContract {
    interface View : MainContract.View {
        fun updateTodoList(pendingTodos: ArrayList<Todo>, completedTodos: ArrayList<Todo>)
    }

    interface Presenter : MainContract.Presenter {

    }
}