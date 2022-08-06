package com.jeanbernuy.pokemonapp.data.repository

import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.model.Pokemon
import com.jeanbernuy.pokemonapp.data.remote.PokemonDataSource

class PokemonDataRepository(private val pokemonDataSource: PokemonDataSource) : PokemonRepository {

    override suspend fun fetchPokemonById(id: String): Resource<Pokemon> {
        return pokemonDataSource.fetchPokemonById(id)
    }
}