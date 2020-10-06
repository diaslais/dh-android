package com.laisd.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener {
            var tempCelsius = edtTemperatura.text.toString().toDouble()
            var tempFahrenheit = ((tempCelsius * 9) / 5) + 32
            txtResultado.text = getString(R.string.result, tempFahrenheit)
        }
    }
}