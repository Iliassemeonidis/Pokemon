package com.example.repository.repository.datasourse.main.local

import com.example.model.AppState

interface DataSoursLocal<T> {
    suspend fun saveToDB(appState: com.example.model.AppState)
    suspend fun getData(): T
}