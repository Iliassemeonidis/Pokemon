package com.example.pokemon.model.datasourse.main.local

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceLocalImpl(private val remote: RoomDataBaseImplementation) :
    DataSoursLocal<PokemonResultData> {

    override suspend fun saveToDB(appState: AppState) {
        remote.saveToDB(appState)
    }

    override suspend fun getData(): PokemonResultData {
        return remote.getData()
    }
}