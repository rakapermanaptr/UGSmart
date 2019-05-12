package com.example.ugsmart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ugsmart.R
import com.example.ugsmart.model.Menu
import kotlinx.android.synthetic.main.item_grid.view.*

class GridAdapter : BaseAdapter {

    var menuList = ArrayList<Menu>()
    var context: Context? = null

    constructor(context: Context, menuList: ArrayList<Menu>) : super() {
        this.context = context
        this.menuList = menuList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val menu = this.menuList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var menuView = inflator.inflate(R.layout.item_grid, null)
        menuView.imgIcon.setImageResource(menu.imgIcon!!)
        menuView.tvTitle.text = menu.title
        menuView.tvDescTitle.setText(menu.desc!!)

        return menuView
    }

    override fun getItem(position: Int): Any {
        return menuList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return menuList.size
    }


}