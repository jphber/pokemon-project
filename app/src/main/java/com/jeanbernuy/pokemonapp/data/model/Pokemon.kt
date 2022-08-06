package com.jeanbernuy.pokemonapp.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("sprites") var sprites: Sprites? = Sprites()
)