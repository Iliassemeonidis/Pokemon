package com.example.pokemon.interactor

interface InteractorDetails<T> {
    suspend fun getImagePokemon(url : String) : T
}