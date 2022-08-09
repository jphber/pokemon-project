package com.jeanbernuy.pokemonapp.data.repository

import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.model.Pokemon
import com.jeanbernuy.pokemonapp.data.remote.PokemonDataSource
import javax.inject.Inject

class PokemonRepository_Impl @Inject constructor(
    private val pokemonDataSource: PokemonDataSource
) : PokemonRepository {

    override suspend fun fetchPokemonById(id: String): Resource<Pokemon> {
        return pokemonDataSource.fetchPokemonById(id)
    }
}