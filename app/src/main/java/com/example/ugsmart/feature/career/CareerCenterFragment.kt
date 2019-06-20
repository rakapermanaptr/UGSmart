package com.example.ugsmart.feature.career


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.adapter.CareerAdapter
import com.example.ugsmart.adapter.NewsAdapter
import com.example.ugsmart.model.News
import com.example.ugsmart.model.repository.NewsRepoImpl
import com.example.ugsmart.network.ApiRest
import com.example.ugsmart.network.ApiService
import com.example.ugsmart.utils.invisible
import com.example.ugsmart.utils.visible
import kotlinx.android.synthetic.main.fragment_career_center.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CareerCenterFragment : Fragment(), CareerCenterContract.View {

    private lateinit var presenter: CareerCenterPresenter
    private val careerList: MutableList<News> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = "Career Center"

        val service = ApiService.getClient().create(ApiRest::class.java)
        val request = NewsRepoImpl(service)
        presenter = CareerCenterPresenter(this, request)
        presenter.getAllCareer()
    }

    override fun showLoading() {
        progressBar.visible()
        rvNews.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        rvNews.visible()
    }

    override fun showAllCareer(careers: List<News>) {
        careerList.clear()
        careerList.addAll(careers)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager = linearLayoutManager
        rvNews.adapter = CareerAdapter(requireContext(), careers)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_career_center, container, false)
    }


}
