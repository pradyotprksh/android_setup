package com.pradyotprkshprksh.home.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pradyotprkshprksh.R
import com.pradyotprkshprksh.home.presenter.models.Todo
import com.pradyotprkshprksh.utility.Utility
import kotlinx.android.synthetic.main.single_todo.view.*
import java.util.ArrayList

class TodoRecyclerAdapter(private val todos: ArrayList<Todo>) :
    RecyclerView.Adapter<TodoRecyclerAdapter.Adapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.single_todo, parent, false)
        return Adapter(view)
    }

    override fun onBindViewHolder(holder: Adapter, position: Int) {
        holder.itemView.todoVal.text = todos[position].description
        holder.itemView.todoDate.text = Utility().getDatefromTimestamp(todos[position].scheduledDate)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class Adapter(v: View) : RecyclerView.ViewHolder(v)
}