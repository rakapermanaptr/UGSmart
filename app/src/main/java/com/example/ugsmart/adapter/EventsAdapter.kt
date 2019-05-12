package com.example.ugsmart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ugsmart.R
import com.example.ugsmart.feature.detail.DetailEventActivity
import com.example.ugsmart.model.Event
import kotlinx.android.synthetic.main.item_event.view.*
import org.jetbrains.anko.startActivity

class EventsAdapter(private val context: Context, private val events: List<Event>) :
    RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_event,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(events[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(event: Event) {
            Glide.with(itemView)
                .load(event.url)
                .into(itemView.imgPoster)
            itemView.tvTitle.text = event.title
            itemView.tvDate.text = event.date
            itemView.tvTime.text = event.time
            itemView.tvLocation.text = event.location

            Log.i("data", "title : " + event.url)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailEventActivity>("data" to event)
//                itemView.context.toast("test")
            }
        }

    }
}