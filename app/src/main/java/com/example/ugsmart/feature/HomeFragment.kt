package com.example.ugsmart.feature


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.adapter.MenuAdapter
import com.example.ugsmart.model.Menu
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = "UGSmart"

        val listMenu = listOf<Menu>(
            Menu(title = "Report", imgIcon = R.drawable.report, desc = R.string.report_desc),
            Menu(title = "News", imgIcon = R.drawable.news_purple, desc = R.string.news_desc),
            Menu(title = "Event and Seminar", imgIcon = R.drawable.event_purple, desc = R.string.event_desc),
            Menu(title = "Jobs", imgIcon = R.drawable.jobs_purple, desc = R.string.jobs_desc)
        )

        val menuAdapter = MenuAdapter(requireContext(), listMenu)

        rvHome.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = menuAdapter
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
