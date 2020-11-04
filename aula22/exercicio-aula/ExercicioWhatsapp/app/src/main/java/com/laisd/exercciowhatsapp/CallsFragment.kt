package com.laisd.exercciowhatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CallsFragment : Fragment() {
    private lateinit var callsView: View
    private lateinit var callsRecyclerView: RecyclerView

    val callsDataSet = arrayListOf<Call>(
        Call(R.drawable.image_1, "Thor", "20 October, 19:35"),
        Call(R.drawable.image_2, "Rex", "20 October, 19:35"),
        Call(R.drawable.image_3, "Nina", "20 October, 19:35"),
        Call(R.drawable.image_4, "Pintinho", "20 October, 19:35"),
        Call(R.drawable.image_5, "Belinha", "20 October, 19:35"),
        Call(R.drawable.image_1, "Thor", "20 October, 19:35"),
        Call(R.drawable.image_5, "Belinha", "20 October, 19:35"),
        Call(R.drawable.image_3, "Nina", "20 October, 19:35"),
        Call(R.drawable.image_4, "Pintinho", "20 October, 19:35")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        callsView = inflater.inflate(R.layout.fragment_calls, container, false)
        return callsView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //recyclerview
        callsRecyclerView = callsView.findViewById(R.id.listaDeCalls)

        callsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CallsAdapter(callsDataSet)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}