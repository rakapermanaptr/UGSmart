package com.example.ugsmart.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.ugsmart.R
import com.example.ugsmart.adapter.HomeEventsAdapter
import com.example.ugsmart.adapter.HomeNewsAdapter
import com.example.ugsmart.model.BannerData
import com.example.ugsmart.model.Event
import com.example.ugsmart.model.News
import com.example.ugsmart.model.repository.NewsRepoImpl
import com.example.ugsmart.network.ApiRest
import com.example.ugsmart.network.ApiService
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var presenter: HomePresenter
    private var listHomeNews: MutableList<News> = mutableListOf()
    private var listHomeEvents: MutableList<Event> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = "UGSmart"

        val service = ApiService.getClient().create(ApiRest::class.java)
        val request = NewsRepoImpl(service)
        presenter = HomePresenter(this, request)
        presenter.getHomeNews()
        presenter.getEventsAndSeminars()
        presenter.getHomeBanner()

    }

    override fun showHomeBanner(data: List<BannerData>) {
        val rectorImgUrl = data[0].rectorImg
//        Glide.with(act)
//            .load(rectorImgUrl)
//            .into(imgRektor)

        Log.d("Data", "rector img : " + rectorImgUrl)

        tvRectorName.text = data[0].rectorName
        tvRectorGreeting.text = data[0].rectorGreeting
        tvAnnouncementTitle.text = data[0].announcement_title
        tvAnnouncement.text = data[0].announcement
    }

    override fun showHomeNews(news: List<News>) {
        listHomeNews.clear()
        listHomeNews.addAll(news)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvUgNewsHome.layoutManager = linearLayoutManager
        rvUgNewsHome.adapter = HomeNewsAdapter(requireContext(), listHomeNews)
    }

    override fun showEventsAndSeminars(events: List<Event>) {
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
