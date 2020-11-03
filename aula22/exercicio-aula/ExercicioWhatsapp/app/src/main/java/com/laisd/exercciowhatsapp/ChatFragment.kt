package com.laisd.exercciowhatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatFragment : Fragment() {
    /*
    val todasAsMensagens = arrayListOf(
        Mensagem(R.drawable.image_1, "Thor", "Puts tive que fazer xixi na pracinha ontem :(", "15:30"),
        Mensagem(R.drawable.image_2, "Rex","Você viu quem fez xixi na pracinha ontem?","16:00"),
        Mensagem(R.drawable.image_3, "Nina", "Oi amigo, tudo jóia?", "16:15"),
        Mensagem(R.drawable.image_4, "Pintinho", "Tenho uma piada para te contar", "16:30"),
        Mensagem(R.drawable.image_5, "Marley", "Se cuida para não pegar Cãovid!", "17:30"),
        Mensagem(R.drawable.image_1, "Thor", "Puts tive que fazer xixi na pracinha ontem :(", "15:30"),
        Mensagem(R.drawable.image_2, "Rex","Você viu quem fez xixi na pracinha ontem?","16:00"),
        Mensagem(R.drawable.image_3, "Nina", "Oi amigo, tudo jóia?", "16:15"),
        Mensagem(R.drawable.image_4, "Pintinho", "Tenho uma piada para te contar", "16:30"),
        Mensagem(R.drawable.image_5, "Marley", "Se cuida para não pegar Cãovid!", "17:30")
    )
    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
        }
}
