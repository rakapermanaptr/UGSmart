package com.example.ugsmart.feature.news.ug


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ugsmart.R
import com.example.ugsmart.adapter.NewsAdapter
import com.example.ugsmart.model.News
import com.example.ugsmart.utils.invisible
import com.example.ugsmart.utils.visible
import kotlinx.android.synthetic.main.fragment_ug__news.*

class UGNewsFragment : Fragment(), UGNewsContract.View {

    private lateinit var presenter: UGNewsPresenter
    private var listNews: MutableList<News> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = UGNewsPresenter(this)
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
        return inflater.inflate(R.layout.fragment_ug__news, container, false)
    }


}
