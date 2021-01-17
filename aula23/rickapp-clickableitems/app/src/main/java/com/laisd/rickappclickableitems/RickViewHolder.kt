package com.laisd.rickappclickableitems

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laisd.rickappclickableitems.rickandmortyapi.Personagem
import com.squareup.picasso.Picasso

class RickViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nome = view.findViewById<TextView>(R.id.listNome)
    private val imagem = view.findViewById<ImageView>(R.id.listImage)

    fun bind(personagem: Personagem) {
        nome.text = personagem.nome

        Picasso.get()
                .load(personagem.imagemUrl)
                .into(imagem)
    }
}