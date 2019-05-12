package com.example.ugsmart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.model.Menu
import kotlinx.android.synthetic.main.item_grid.view.*
import org.jetbrains.anko.toast

class MenuAdapter(private val context: Context, private val menu: List<Menu>) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_grid,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(menu[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(menu: Menu) {
            itemView.tvTitle.text = menu.title
            itemView.tvDescTitle.setText(menu.desc!!)
            itemView.imgIcon.setImageResource(menu.imgIcon!!)

            itemView.setOnClickListener {
                itemView.context.toast("Menu : " + menu.title)
            }
        }

    }
}