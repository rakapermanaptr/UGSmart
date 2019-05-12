package com.example.ugsmart.feature.reports


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.adapter.ReportsAdapter
import com.example.ugsmart.feature.report.ReportActivity
import com.example.ugsmart.model.Report
import com.example.ugsmart.model.repository.ReportRepoImpl
import com.example.ugsmart.network.ApiRest
import com.example.ugsmart.network.ApiService
import com.example.ugsmart.utils.invisible
import com.example.ugsmart.utils.visible
import kotlinx.android.synthetic.main.fragment_reports.*
import org.jetbrains.anko.support.v4.startActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ReportsFragment : Fragment(), ReportsContract.View {

    private lateinit var presenter: ReportsPresenter
    private var reports: MutableList<Report> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = "Reports"

        val service = ApiService.getClient().create(ApiRest::class.java)
        val request = ReportRepoImpl(service)
        presenter = ReportsPresenter(this, request)
        presenter.getReports()

        fab.setOnClickListener { startActivity<ReportActivity>() }

    }

    override fun showLoading() {
        progressBar.visible()
        rvReports.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        rvReports.visible()
    }

    override fun showReports(report: List<Report>) {
        reports.clear()
        reports.addAll(report)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvReports.layoutManager = linearLayoutManager
        rvReports.adapter = ReportsAdapter(requireContext(), reports)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter.getReports()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reports, container, false)
    }


}
