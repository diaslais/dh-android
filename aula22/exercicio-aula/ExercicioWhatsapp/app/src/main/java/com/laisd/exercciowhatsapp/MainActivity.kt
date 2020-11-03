package com.laisd.exercciowhatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentChat = ChatFragment()
        val fragmentStatus = StatusFragment()
        val fragmentCalls = CallsFragment()

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        //ViewPager
        tabLayout.setupWithViewPager(viewPager)
        val fragments = listOf(fragmentChat, fragmentStatus, fragmentCalls)
        val titulos = listOf("Chats", "Status", "Calls")
        viewPager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)

    }
}