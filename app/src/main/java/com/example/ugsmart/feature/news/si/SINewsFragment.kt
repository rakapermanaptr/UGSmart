package com.example.ugsmart.feature.news.si


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ugsmart.R
import com.example.ugsmart.adapter.NewsAdapter
import com.example.ugsmart.model.News
import com.example.ugsmart.model.repository.NewsRepoImpl
import com.example.ugsmart.network.ApiRest
import com.example.ugsmart.network.ApiService
import com.example.ugsmart.utils.invisible
import com.example.ugsmart.utils.visible
import kotlinx.android.synthetic.main.fragment_si__news.*

class SINewsFragment : Fragment(), SINewsContract.View {

    private lateinit var presenter: SINewsPresenter
    private val listNews: MutableList<News> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SINewsPresenter(this)
        presenter.getAllNews()

    }

    override fun showLoading() {
        progressBar.visible()
        rvNews.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        rvNews.visible()
    }

    override fun showAllNews(news: MutableList<News>) {
        listNews.reverse()
        listNews.clear()
        listNews.addAll(news)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager = linearLayoutManager
        rvNews.adapter = NewsAdapter(requireContext(), news)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_si__news, container, false)
    }


}
