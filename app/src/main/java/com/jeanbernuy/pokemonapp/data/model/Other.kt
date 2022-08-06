package com.jeanbernuy.pokemonapp.data.model

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world") var dreamWorld: DreamWorld? = DreamWorld(),
    @SerializedName("home") var home: Home? = Home(),
    @SerializedName("official-artwork") var officialArtwork: OfficialArtwork? = OfficialArtwork()
)
