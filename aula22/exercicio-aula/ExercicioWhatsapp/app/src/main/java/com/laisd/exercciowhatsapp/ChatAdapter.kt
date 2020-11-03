package com.laisd.exercciowhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class ChatAdapter(private val dataSet: List<Mensagem>): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val fotoChat by lazy { itemView.findViewById<ImageView>(R.id.imgMensagem) }
        private val nomeChat by lazy { itemView.findViewById<MaterialTextView>(R.id.txtMensagemNome) }
        private val mensagemChat by lazy { itemView.findViewById<MaterialTextView>(R.id.txtMensagemMensagem) }
        private val dataChat by lazy { itemView.findViewById<MaterialTextView>(R.id.txtMensagemData) }

        fun bind(mensagem: Mensagem){
            fotoChat.setImageResource(mensagem.imagemSrc)
            nomeChat.text = mensagem.nome
            mensagemChat.text = mensagem.mensagem
            dataChat.text = mensagem.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.messages, parent, false)
        return ChatViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}

