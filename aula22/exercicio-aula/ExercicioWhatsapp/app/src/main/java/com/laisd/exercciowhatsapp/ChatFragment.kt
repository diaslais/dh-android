package com.laisd.exercciowhatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatFragment : Fragment() {
    private lateinit var chatView: View
    private lateinit var chatRecyclerView: RecyclerView

    val chatDataSet = arrayListOf(
        Mensagem(R.drawable.image_1, "Thor", "Puts ontem tive que fazer xixi na pracinha :(", "15:30"),
        Mensagem(R.drawable.image_2, "Rex","Você viu quem fez xixi na pracinha?","16:00"),
        Mensagem(R.drawable.image_3, "Nina", "Oi amigo, tudo jóia?", "16:15"),
        Mensagem(R.drawable.image_4, "Pintinho", "Tenho uma piada boa para te contar", "16:30"),
        Mensagem(R.drawable.image_5, "Belinha", "Au au", "17:30"),
        Mensagem(R.drawable.image_1, "Thor", "Puts ontem tive que fazer xixi na pracinha :(", "15:30"),
        Mensagem(R.drawable.image_2, "Rex","Você viu quem fez xixi na pracinha?","16:00"),
        Mensagem(R.drawable.image_3, "Nina", "Oi amigo, tudo jóia?", "16:15"),
        Mensagem(R.drawable.image_4, "Pintinho", "Tenho uma piada boa para te contar", "16:30"),
        Mensagem(R.drawable.image_5, "Belinha", "Au au", "17:30")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        chatView = inflater.inflate(R.layout.fragment_chat, container, false)
        return chatView
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //wire up our recyclerview
        chatRecyclerView = chatView.findViewById(R.id.listaDeMensagens)
        chatRecyclerView.setHasFixedSize(true)
        chatRecyclerView.layoutManager = LinearLayoutManager(context)
        chatRecyclerView.adapter = ChatAdapter(chatDataSet)
        chatRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}
