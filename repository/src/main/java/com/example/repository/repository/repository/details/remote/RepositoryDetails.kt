package com.example.repository.repository.repository.details.remote

import com.example.model.AppState

interface RepositoryDetails<T> {
    suspend fun getImagePokemonData(isOnline: Boolean,url: String): T
    suspend fun saveImageToDB(appState: com.example.model.AppState)
}