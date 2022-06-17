package com.example.repository.repository.datasourse.main.local

import com.example.repository.repository.datasourse.RoomDataBaseImplementation

class DataSourceLocalImpl(private val remote: RoomDataBaseImplementation) :
    DataSoursLocal<com.example.model.result.PokemonResultData> {

    override suspend fun saveToDB(appState: com.example.model.AppState) {
        remote.saveToDB(appState)
    }

    override suspend fun getData(): com.example.model.result.PokemonResultData {
        return remote.getData()
    }
}