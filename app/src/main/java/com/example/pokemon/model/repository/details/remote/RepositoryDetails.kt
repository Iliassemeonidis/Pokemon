package com.example.pokemon.model.repository.details.remote

import com.example.pokemon.model.data.AppState

interface RepositoryDetails<T> {
    suspend fun getImagePokemonData(isOnline: Boolean,url: String): T
    suspend fun saveImageToDB(appState: AppState)
}