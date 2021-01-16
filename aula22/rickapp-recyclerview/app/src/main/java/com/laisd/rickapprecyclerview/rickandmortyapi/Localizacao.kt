package com.laisd.rickapprecyclerview.rickandmortyapi

import com.google.gson.annotations.SerializedName

data class Localizacao(
    @SerializedName("name")
    var nome : String
)