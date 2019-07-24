package com.example.ugsmart.feature.news


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ugsmart.R
import com.example.ugsmart.adapter.ViewPagerAdapter
import com.example.ugsmart.feature.news.baak.BAAKNewsFragment
import com.example.ugsmart.feature.news.si.SINewsFragment
import com.example.ugsmart.feature.news.sk.SKNewsFragment
import com.example.ugsmart.feature.news.ti.TINewsFragment
import com.example.ugsmart.feature.news.ug.UGNewsFragment
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = "News"

        val adapter = ViewPagerAdapter(childFragmentManager)
        val ugNewsFragment = UGNewsFragment()
        val baakNewsFragment = BAAKNewsFragment()
        val siNewsFragment = SINewsFragment()
        val skNewsFragment = SKNewsFragment()
        val tiNewsFragment = TINewsFragment()
        adapter.populateFragment(ugNewsFragment, "UG")
        adapter.populateFragment(baakNewsFragment, "BAAK")
        adapter.populateFragment(siNewsFragment, "SISTEM INFORMASI")
        adapter.populateFragment(skNewsFragment, "SISTEM KOMPUTER")
        adapter.populateFragment(tiNewsFragment, "TEKNIK INFORMATIKA")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


}
