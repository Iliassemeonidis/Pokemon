package com.example.repository.repository.repository.main.local

import com.example.model.AppState

interface RepositoryLocal<T> {
    suspend fun saveToDB(appState: com.example.model.AppState)
}