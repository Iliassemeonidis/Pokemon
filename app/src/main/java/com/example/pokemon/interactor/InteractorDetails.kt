package com.example.pokemon.interactor

interface InteractorDetails<T> {
    suspend fun getImagePokemon(isOnline: Boolean,url: String): T
}