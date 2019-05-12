package com.example.ugsmart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ugsmart.R
import com.example.ugsmart.model.Report
import kotlinx.android.synthetic.main.item_report.view.*

class ReportsAdapter(private val context: Context, private val reports: List<Report>) :
    RecyclerView.Adapter<ReportsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_report,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = reports.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(reports[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(report: Report) {
            itemView.tvUsername.text = report.fullname
            itemView.tvSubject.text = report.subject
            itemView.tvComplaint.text = report.complaint
            itemView.tvLocation.text = report.location
            itemView.tvNote.text = report.note

            Log.i("data", "subject : " + report.note)
        }
    }
}