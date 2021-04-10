package com.pradyotprkshprksh.home.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pradyotprkshprksh.R
import com.pradyotprkshprksh.home.HomeContract
import com.pradyotprkshprksh.home.presenter.models.Todo
import com.pradyotprkshprksh.home.view.adapters.TodoListViewPagerAdapter
import kotlinx.android.synthetic.main.view_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.ArrayList

/**
 * The view part of our home module which will be used in initializing our views and
 * updating it based on the conditions or the needs.
 */
class HomeView : AppCompatActivity(), HomeContract.View {

    private val homePresenter: HomeContract.Presenter by inject { parametersOf(this) }

    private lateinit var todoListViewPagerAdapter: TodoListViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_home)

        homePresenter.start()
    }

    override fun getTodoList(pendingTodos: ArrayList<Todo>, completedTodos: ArrayList<Todo>) {
        todoListViewPagerAdapter = TodoListViewPagerAdapter(this, pendingTodos, completedTodos)
        viewPage.adapter = todoListViewPagerAdapter

        TabLayoutMediator(tabLayout, viewPage) {tab: TabLayout.Tab, position: Int ->
            if (position == 0) {
                tab.text = getString(R.string.pending)
            } else {
                tab.text = getString(R.string.completed)
            }
            viewPage.setCurrentItem(tab.position, true)
        }.attach()
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