package com.laisd.exercicio2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EntradaFragment : Fragment() {
    lateinit var iClick: IClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iClick = context as IClick
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val entradaView = inflater.inflate(R.layout.fragment_entrada, container, false)
        cliqueBotao(entradaView)
        return entradaView
    }

    fun cliqueBotao(view: View){
        val btnCalcular = view.findViewById<Button>(R.id.btnCalcula)

        btnCalcular.setOnClickListener {
            val nome = view.findViewById<TextInputEditText>(R.id.txtInputEdtNome)
            val ano = view.findViewById<TextInputEditText>(R.id.txtInputEdtAno)
            if (nome.text.toString().isEmpty()){
                nome.error = "Digite um nome"
            }
            else if (ano.text.toString().isEmpty()){
                ano.error = "Digite o ano de nascimento"
            }
            else{
                iClick.clickCalcular(nome.text.toString(), ano.text.toString())
            }
        }
    }

}