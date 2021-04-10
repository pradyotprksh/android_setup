package com.pradyotprkshprksh.home.view.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pradyotprkshprksh.home.presenter.models.Todo
import com.pradyotprkshprksh.home.view.completed.CompletedFragment
import com.pradyotprkshprksh.home.view.pending.PendingFragment

/**
 * View pager adapter for the home view
 */
class TodoListViewPagerAdapter(fragmentActivity: FragmentActivity,
                               private val pendingTodo: java.util.ArrayList<Todo>,
                               private val completedTodo: java.util.ArrayList<Todo>)
    : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        if (position == 0) {
            val pendingFragment = PendingFragment()
            bundle.putParcelableArrayList("pendingTodo", pendingTodo)
            pendingFragment.arguments = bundle
            return pendingFragment
        }
        val completedFragment = CompletedFragment()
        bundle.putParcelableArrayList("completedTodo", completedTodo)
        completedFragment.arguments = bundle
        return completedFragment
    }
}