package com.example.pokemon.model.datasourse.details.local

import com.example.pokemon.model.data.AppState

interface DataSoursDetailsLocal<T> {
    suspend fun getPokemonImageData(url: String): T
    suspend fun saveImageToDB(appState: AppState)
}