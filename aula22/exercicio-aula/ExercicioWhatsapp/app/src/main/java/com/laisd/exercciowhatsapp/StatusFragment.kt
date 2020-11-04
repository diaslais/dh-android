package com.laisd.exercciowhatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StatusFragment : Fragment(){
    private lateinit var statusView: View
    private lateinit var statusRecyclerView: RecyclerView

    val statusDataSet = arrayListOf<Status>(
        Status(R.drawable.image_1, "Rex", "Today, 00:04"),
        Status(R.drawable.image_3, "Rex", "Today, 00:04"),
        Status(R.drawable.image_4, "Rex", "Today, 00:04"),
        Status(R.drawable.image_5, "Rex", "Today, 00:04")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        statusView = inflater.inflate(R.layout.fragment_status, container, false)
        return statusView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //recyclerview
        statusRecyclerView = statusView.findViewById(R.id.listaDeStatus)

        statusRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = StatusAdapter(statusDataSet)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}