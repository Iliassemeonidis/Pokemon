package com.example.pokemon.model.datasourse.main

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceLocal(private val remote: RoomDataBaseImplementation) :
    DataSours<AppState, DetailsPokemonData> {

    override suspend fun getData(): AppState = remote.getData()

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        TODO("Not yet implemented")
    }
}