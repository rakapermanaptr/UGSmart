package com.example.ugsmart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.feature.detail.DetailCareerActivity
import com.example.ugsmart.model.News
import kotlinx.android.synthetic.main.item_news.view.*
import org.jetbrains.anko.startActivity

class CareerAdapter(private val context: Context, private val news: List<News>) :
    RecyclerView.Adapter<CareerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_news,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(news[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(news: News) {
            itemView.tvTitle.text = news.title
            itemView.tvDate.text = news.date
            itemView.tvDescription.text = news.description

            Log.i("data", "title : " + news.title)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailCareerActivity>("data" to news)
            }
        }
    }
}