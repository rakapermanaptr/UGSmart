package com.example.ugsmart.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.ugsmart.R
import com.example.ugsmart.adapter.HomeEventsAdapter
import com.example.ugsmart.adapter.HomeNewsAdapter
import com.example.ugsmart.feature.detail.DetailSambutanActivity
import com.example.ugsmart.model.BannerData
import com.example.ugsmart.model.Event
import com.example.ugsmart.model.News
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var presenter: HomePresenter
    private var listHomeNews: MutableList<News> = mutableListOf()
    private var listHomeEvents: MutableList<Event> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = "UGSmart"

        presenter = HomePresenter(this)
        presenter.getHomeNews()
        presenter.getEventsAndSeminars()
        presenter.getHomeBanner()

    }

    override fun showHomeBanner(data: BannerData) {
        val rectorImgUrl = data.rectorImg
        Glide.with(this!!.activity!!)
            .load(rectorImgUrl)
            .into(imgRektor)

        Log.d("Data", "rector img : " + rectorImgUrl)

        tvRectorName.text = data.rectorName
        tvRectorGreeting.text = data.rectorGreeting
        tvAnnouncementTitle.text = data.announcement_title
        tvAnnouncement.text = data.announcement

        layoutSambutan.setOnClickListener {
            startActivity<DetailSambutanActivity>("data" to data)
        }
    }

    override fun showHomeNews(news: MutableList<News>) {
        listHomeNews.clear()
        listHomeNews.addAll(news)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvUgNewsHome.layoutManager = linearLayoutManager
        rvUgNewsHome.adapter = HomeNewsAdapter(requireContext(), listHomeNews)
    }

    override fun showEventsAndSeminars(events: MutableList<Event>) {
        listHomeEvents.clear()
        listHomeEvents.addAll(events)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvEventSeminarHome.layoutManager = linearLayoutManager
        rvEventSeminarHome.adapter = HomeEventsAdapter(requireContext(), listHomeEvents)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
