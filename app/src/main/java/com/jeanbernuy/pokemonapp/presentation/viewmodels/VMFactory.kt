package com.jeanbernuy.pokemonapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbernuy.pokemonapp.data.repository.PokemonRepository

class VMFactory(private val repository: PokemonRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PokemonRepository::class.java)
            .newInstance(repository)
    }
}