package com.laisd.rickapprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laisd.rickapprecyclerview.rickandmortyapi.IRespostaDaApi
import com.laisd.rickapprecyclerview.rickandmortyapi.Personagem
import com.laisd.rickapprecyclerview.rickandmortyapi.RickApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                val viewAdapter = RickAdapter(personagens)
                with(recyclerView) {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                }
            }
        })
    }
}