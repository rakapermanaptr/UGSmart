package com.example.ugsmart.feature.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ugsmart.R
import com.example.ugsmart.model.BannerData
import kotlinx.android.synthetic.main.activity_detail_sambutan.*
import org.jetbrains.anko.toast

class DetailSambutanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sambutan)

        val data = intent.getParcelableExtra<BannerData>("data")

        tvRektorName.text = data.rectorName
        tvSambutan.text = data.rectorGreeting
    }
}
