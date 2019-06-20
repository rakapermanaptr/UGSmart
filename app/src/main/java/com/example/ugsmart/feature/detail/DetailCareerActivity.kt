package com.example.ugsmart.feature.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.ugsmart.R
import com.example.ugsmart.model.News
import kotlinx.android.synthetic.main.activity_detail_career.*

class DetailCareerActivity : AppCompatActivity() {

    private lateinit var data: News

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_career)

        supportActionBar?.title = "Career Center"

        data = intent.getParcelableExtra<News>("data")

        initData()
    }

    fun initData() {
        tvTitle.text = data.title
        tvDate.text = data.date
        tvDescription.text = data.description
    }

}
