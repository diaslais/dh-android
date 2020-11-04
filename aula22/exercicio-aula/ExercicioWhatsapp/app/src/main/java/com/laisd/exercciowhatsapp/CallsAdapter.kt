package com.laisd.exercciowhatsapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class CallsAdapter(private val dataSet: List<Call>): RecyclerView.Adapter<CallsAdapter.CallsViewHolder>()  {

    class CallsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var fotoCalls = itemView.findViewById<ImageView>(R.id.imgCall)
        private var nomeCalls = itemView.findViewById<MaterialTextView>(R.id.txtCallNome)
        private var dataCalls = itemView.findViewById<MaterialTextView>(R.id.txtCallData)

        fun bind(call: Call){
            fotoCalls.setImageResource(call.imageSrc)
            nomeCalls.text = call.nome
            dataCalls.text = call.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calls, parent, false)
        return CallsViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: CallsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


}