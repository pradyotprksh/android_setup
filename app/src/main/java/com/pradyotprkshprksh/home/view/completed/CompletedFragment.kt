package com.pradyotprkshprksh.home.view.completed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pradyotprkshprksh.R
import com.pradyotprkshprksh.home.presenter.models.Todo
import com.pradyotprkshprksh.home.view.adapters.TodoRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_completed.*
import kotlinx.android.synthetic.main.fragment_completed.view.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class CompletedFragment : Fragment() {

    var completedTodos: ArrayList<Todo> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_completed, container, false)
        intiView(view)
        return view
    }

    private fun intiView(view: View) {
        val arguments = arguments
        if (arguments != null) {
            completedTodos = arguments.getParcelableArrayList("completedTodo")!!

            val todoRecyclerAdapter = TodoRecyclerAdapter(completedTodos)
            view.rvCompleted.layoutManager = LinearLayoutManager(context)
            view.rvCompleted.adapter = todoRecyclerAdapter

            todoRecyclerAdapter.notifyDataSetChanged()
        }
    }
}