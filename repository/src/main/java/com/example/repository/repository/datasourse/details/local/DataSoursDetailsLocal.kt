package com.example.repository.repository.datasourse.details.local

import com.example.model.AppState

interface DataSoursDetailsLocal<T> {
    suspend fun getPokemonImageData(url: String): T
    suspend fun saveImageToDB(appState: com.example.model.AppState)
}