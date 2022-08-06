package com.jeanbernuy.pokemonapp.data.remote

import com.jeanbernuy.pokemonapp.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") id: String
    ): Pokemon
}