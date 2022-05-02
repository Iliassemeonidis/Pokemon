package com.example.pokemon.model.repository.details

interface RepositoryDetails<T> {
    suspend fun getImagePokemonData(url: String): T
}