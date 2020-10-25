package com.laisd.exercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        val transaction1 = manager.beginTransaction()
        transaction1.add(R.id.containerA, AFragment())
        transaction1.commit()

        val transaction2 = manager.beginTransaction()
        transaction2.add(R.id.containerB, BFragment())
        transaction2.commit()
    }
}