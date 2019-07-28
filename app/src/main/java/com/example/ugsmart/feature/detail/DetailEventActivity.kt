package com.example.ugsmart.feature.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.bumptech.glide.Glide
import com.example.ugsmart.R
import com.example.ugsmart.model.Event
import kotlinx.android.synthetic.main.activity_detail_event.*

class DetailEventActivity : AppCompatActivity() {

    private lateinit var data: Event
    private var menuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)

        data = intent.getParcelableExtra("data")

        supportActionBar?.title = "Event and Seminar"

        initData()
    }

    private fun initData() {
        tvTitle.text = data.title
        tvDate.text = data.date
        tvTime.text = data.time
        tvLocation.text = data.location
        tvDescription.text = data.description
        Glide.with(this)
            .load(data.url)
            .into(imgPoster)
    }

}
