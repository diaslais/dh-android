package com.laisd.exercicio2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_saida.*

class SaidaFragment : Fragment() {
    lateinit var saidaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        saidaView = inflater.inflate(R.layout.fragment_saida, container, false)

        return saidaView
    }

    fun mudaTexto(texto: String){
        txtResultado.text = texto
    }
}