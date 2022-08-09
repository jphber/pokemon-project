package com.jeanbernuy.pokemonapp.data.remote

import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.model.Pokemon
import javax.inject.Inject

class PokemonDataSource @Inject constructor(
    private val webService: WebService
) {
    suspend fun fetchPokemonById(id: String): Resource<Pokemon> {
        return Resource.Success(webService.getPokemonById(id))
    }
}