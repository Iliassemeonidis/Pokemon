package com.example.repository.repository.datasourse.details.local

import com.example.repository.repository.datasourse.RoomDataBaseImplementation

class DataSourceDetailsLocalImpl(
    private val remote: RoomDataBaseImplementation
) : DataSoursDetailsLocal<com.example.model.details.DetailsPokemonData> {

    override suspend fun getPokemonImageData(url: String): com.example.model.details.DetailsPokemonData {
        return remote.getPokemonImageData(url)
    }

    override suspend fun saveImageToDB(appState: com.example.model.AppState) {
        remote.saveImageToDB(appState)
    }
}