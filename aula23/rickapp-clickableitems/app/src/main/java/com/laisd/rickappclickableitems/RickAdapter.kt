package com.laisd.rickappclickableitems

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laisd.rickappclickableitems.rickandmortyapi.Personagem

class RickAdapter (private val dataSet: List<Personagem>, private val listener: (Personagem) -> Unit):
        RecyclerView.Adapter<RickViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return RickViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: RickViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }
}