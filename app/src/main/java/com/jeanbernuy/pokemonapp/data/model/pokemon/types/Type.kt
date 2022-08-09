package com.jeanbernuy.pokemonapp.data.model.pokemon.types

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type(

    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
) : Parcelable