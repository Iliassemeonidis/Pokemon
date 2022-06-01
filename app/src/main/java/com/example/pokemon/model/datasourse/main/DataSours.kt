package com.example.pokemon.model.datasourse.main

import com.example.pokemon.model.data.AppState

interface DataSours<T,V> {
    suspend fun getData(): T
    suspend fun getPokemonImageData(url: String): V
    suspend fun saveToDB(appState: AppState)

}