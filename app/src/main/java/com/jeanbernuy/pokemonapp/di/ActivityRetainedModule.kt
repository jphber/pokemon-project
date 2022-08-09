package com.jeanbernuy.pokemonapp.di

import com.jeanbernuy.pokemonapp.data.repository.PokemonRepository_Impl
import com.jeanbernuy.pokemonapp.data.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityRetainedModule {
    @Binds
    abstract fun dataSource(impl: PokemonRepository_Impl): PokemonRepository
}