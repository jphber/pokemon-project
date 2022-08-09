package com.jeanbernuy.pokemonapp.data.model.pokemon.sprites

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OfficialArtwork(
    @SerializedName("front_default") var frontDefault: String? = null
) : Parcelable
