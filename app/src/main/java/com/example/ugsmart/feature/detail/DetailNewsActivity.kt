package com.example.ugsmart.feature.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ugsmart.R
import com.example.ugsmart.model.News
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var data: News

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        data = intent.getParcelableExtra<News>("data")

        initData()

    }

    private fun initData() {
        tvTitle.text = data.title
        tvDate.text = data.date
        tvDescription.text = data.description
    }
}
