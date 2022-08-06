package com.jeanbernuy.pokemonapp.data.repository

import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.model.Pokemon

interface PokemonRepository {
    suspend fun fetchPokemonById(id: String): Resource<Pokemon>
}