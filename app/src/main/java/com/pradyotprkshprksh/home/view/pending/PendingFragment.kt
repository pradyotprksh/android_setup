package com.pradyotprkshprksh.home.view.pending

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradyotprkshprksh.R
import com.pradyotprkshprksh.home.presenter.models.Todo
import com.pradyotprkshprksh.home.view.adapters.TodoRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_completed.*
import kotlinx.android.synthetic.main.fragment_pending.*
import kotlinx.android.synthetic.main.fragment_pending.view.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class PendingFragment : Fragment() {

    var pendingTodos: ArrayList<Todo> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pending, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        val arguments = arguments
        if (arguments != null) {
            pendingTodos = arguments.getParcelableArrayList("pendingTodo")!!

            val todoRecyclerAdapter = TodoRecyclerAdapter(pendingTodos)
            view.rvPending.layoutManager = LinearLayoutManager(context)
            view.rvPending.adapter = todoRecyclerAdapter

            todoRecyclerAdapter.notifyDataSetChanged()
        }
    }
}