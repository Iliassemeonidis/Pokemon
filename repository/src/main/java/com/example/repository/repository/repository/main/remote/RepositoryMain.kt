package com.example.repository.repository.repository.main.remote

import com.example.model.AppState

// Репозиторий представляет собой слой получения и хранения данных
interface RepositoryMain<T> {
    suspend fun getData(isOnline: Boolean): T
    suspend fun saveToDB(appState: com.example.model.AppState)
}