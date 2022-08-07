package com.jeanbernuy.pokemonapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.repository.PokemonRepository
import com.jeanbernuy.pokemonapp.generateRandomId
import kotlinx.coroutines.Dispatchers

class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    val loadPokemon = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val pokemonId = generateRandomId()
            emit(repository.fetchPokemonById(pokemonId))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}