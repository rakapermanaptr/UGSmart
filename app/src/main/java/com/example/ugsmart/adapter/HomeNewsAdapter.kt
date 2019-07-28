package com.example.ugsmart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.feature.detail.DetailNewsActivity
import com.example.ugsmart.model.News
import kotlinx.android.synthetic.main.item_home.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HomeNewsAdapter(private val context: Context, private val news: List<News>) :
    RecyclerView.Adapter<HomeNewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_home,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(news[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(news: News) {
            itemView.tvHomeTitleNews.text = news.title
            itemView.tvHomeNews.text = news.description

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailNewsActivity>("data" to news)
            }
        }

    }
}