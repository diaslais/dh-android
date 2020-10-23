package com.laisd.exercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnA by lazy { findViewById<Button>(R.id.btnFragmentA) }
        val btnB by lazy { findViewById<Button>(R.id.btnFragmentB) }

        val manager = supportFragmentManager

        btnA.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.container, AFragment())
            transaction.commit()
        }

        btnB.setOnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.container, BFragment())
            transaction.commit()
        }
    }
}