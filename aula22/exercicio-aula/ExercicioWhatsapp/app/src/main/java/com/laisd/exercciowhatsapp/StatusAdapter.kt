package com.laisd.exercciowhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class StatusAdapter(private val dataSet: List<Status>): RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {

    class StatusViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var fotoStatus = itemView.findViewById<ImageView>(R.id.imgStatus)
        private var nomeStatus = itemView.findViewById<MaterialTextView>(R.id.txtStatusNome)
        private var dataStatus = itemView.findViewById<MaterialTextView>(R.id.txtStatusData)

        fun bind(status: Status){
            fotoStatus.setImageResource(status.imagemSrc)
            nomeStatus.text = status.nome
            dataStatus.text = status.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.status, parent, false)
        return StatusAdapter.StatusViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}