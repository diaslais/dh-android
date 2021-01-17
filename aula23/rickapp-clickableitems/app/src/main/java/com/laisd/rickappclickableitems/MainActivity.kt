package com.laisd.rickappclickableitems

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laisd.rickappclickableitems.rickandmortyapi.IRespostaDaApi
import com.laisd.rickappclickableitems.rickandmortyapi.Personagem
import com.laisd.rickappclickableitems.rickandmortyapi.RickApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                makeRecyclerview(personagens)
            }
        })
    }

    private fun makeRecyclerview(personagens: List<Personagem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val viewManager = GridLayoutManager(this, 2)

        var toast: Toast? = null

        val customAdapter = RickAdapter(personagens) {
            toast?.cancel()

            toast = Toast.makeText(this@MainActivity, it.nome, Toast.LENGTH_LONG)
            toast?.show()
        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = customAdapter
        }
    }
}