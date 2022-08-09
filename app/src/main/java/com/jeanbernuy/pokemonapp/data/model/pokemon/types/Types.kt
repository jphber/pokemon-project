package com.jeanbernuy.pokemonapp.data.model.pokemon.types

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Types(

    @SerializedName("slot") var slot: Int? = null,
    @SerializedName("type") var type: Type? = Type()
) : Parcelable