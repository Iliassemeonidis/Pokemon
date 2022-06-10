package com.example.pokemon.model.datasourse.main.local

import com.example.pokemon.model.data.AppState

interface DataSoursLocal<T> {
    suspend fun saveToDB(appState: AppState)
    suspend fun getData(): T
}