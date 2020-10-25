package com.laisd.meuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), ILogIn {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //view pager
        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        tab.setupWithViewPager(pager)

        val fragments = listOf(
            SignIn(), SignUp()
        )
        val titulos = listOf(
            getString(R.string.sign_in), getString(R.string.sign_up)
        )

        pager.adapter = Adapter(fragments, titulos, supportFragmentManager)
    }

    override fun logIn() {
        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
    }
}