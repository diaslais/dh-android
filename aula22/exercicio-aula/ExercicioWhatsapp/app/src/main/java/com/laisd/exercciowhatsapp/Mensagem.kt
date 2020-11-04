package com.laisd.exercciowhatsapp

import android.widget.ImageView
import com.google.android.material.textview.MaterialTextView

data class Mensagem(
    val imagemSrc: Int,
    val nome: String,
    val mensagem: String,
    val data: String
)