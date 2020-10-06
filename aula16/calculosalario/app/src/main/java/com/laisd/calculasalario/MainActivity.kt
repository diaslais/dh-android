package com.laisd.calculasalario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            var horasTrabalhadas = edtHoras.text.toString().toDouble()
            var valorHora = edtValor.text.toString().toDouble()
            var salario = horasTrabalhadas * valorHora

            txtResultado.text = getString(R.string.result, salario)
        }
    }
}