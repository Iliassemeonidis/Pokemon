package com.example.pokemon.model.repository.main.local

import com.example.pokemon.model.data.AppState

interface RepositoryLocal<T> {
    suspend fun saveToDB(appState: AppState)
}