package com.jeanbernuy.pokemonapp


// Generated random ID from 1 to 100 included
fun generateRandomId(): String {
    val idGenerated = (1..100).shuffled().last()
    return idGenerated.toString()
}

// Format Pokemon Name to UpperCase
fun formatPokemonName(str: String?): String {
    return str?.uppercase() ?: "Name not available"
}