package com.example.pokemon.model.repository.main.remote

import com.example.pokemon.model.data.AppState

// Репозиторий представляет собой слой получения и хранения данных
interface RepositoryMain<T> {
    suspend fun getData(isOnline: Boolean): T
    suspend fun saveToDB(appState: AppState)
}