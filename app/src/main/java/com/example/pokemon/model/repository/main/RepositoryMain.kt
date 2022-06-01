package com.example.pokemon.model.repository.main

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.repository.room.HistoryEntity

// Репозиторий представляет собой слой получения и хранения данных
interface RepositoryMain<T> {
    suspend fun getData(): T
    suspend fun saveToDB(appState: AppState)
}