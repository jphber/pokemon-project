package com.jeanbernuy.pokemonapp.data.remote

import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.core.RestEngine
import com.jeanbernuy.pokemonapp.data.model.Pokemon

class PokemonDataSource {

    suspend fun fetchPokemonById(id: String): Resource<Pokemon> {
        return Resource.Success(RestEngine.restEngine.getPokemonById(id))
    }
}