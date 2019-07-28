package com.example.ugsmart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.feature.detail.DetailEventActivity
import com.example.ugsmart.model.Event
import kotlinx.android.synthetic.main.item_home_events.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HomeEventsAdapter(private val context: Context, private val events: List<Event>) :
    RecyclerView.Adapter<HomeEventsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_home_events,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(events[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(event: Event) {
            itemView.tvHomeTitleEvent.text = event.title
            itemView.tvHomeEvent.text = event.description

            Log.i("data", "title : " + event.title)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailEventActivity>("data" to event)
            }
        }

    }
}