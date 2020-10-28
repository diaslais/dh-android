package com.laisd.exercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), IClick {
    val manager = supportFragmentManager
    val saidaFragment = SaidaFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transactionEntrada = manager.beginTransaction()
        transactionEntrada.add(R.id.containerEntrada, EntradaFragment())
        transactionEntrada.commit()

        val transactionSaida = manager.beginTransaction()
        transactionSaida.add(R.id.containerSaida, saidaFragment)
        transactionSaida.commit()
    }

    override fun clickCalcular(nome: String, ano: String) {
        val anoAtual = Calendar.getInstance().get(Calendar.YEAR)

        if (anoAtual.compareTo(ano.toInt()) < 0) {
            findViewById<TextView>(R.id.txtResultado).visibility = View.VISIBLE
            saidaFragment.mudaTexto(getString(R.string.nao_nasceu, nome))
        } else {
            val age = anoAtual.minus(ano.toInt())
            findViewById<TextView>(R.id.txtResultado).visibility = View.VISIBLE
            saidaFragment.mudaTexto(getString(R.string.resultado, nome, age))
        }
    }

}