package com.jeanbernuy.pokemonapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.jeanbernuy.pokemonapp.data.model.pokemon.sprites.Sprites
import com.jeanbernuy.pokemonapp.data.model.pokemon.stats.Stats
import com.jeanbernuy.pokemonapp.data.model.pokemon.types.Types
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("sprites") var sprites: Sprites? = Sprites(),
    @SerializedName("stats") var stats: ArrayList<Stats> = arrayListOf(),
    @SerializedName("types") var types: ArrayList<Types> = arrayListOf()
) : Parcelable