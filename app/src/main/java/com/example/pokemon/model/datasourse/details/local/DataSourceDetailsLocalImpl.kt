package com.example.pokemon.model.datasourse.details.local

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.RetrofitImplementation
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceDetailsLocalImpl(
    private val remote: RoomDataBaseImplementation
) : DataSoursDetailsLocal<DetailsPokemonData> {

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        return remote.getPokemonImageData(url)
    }

    override suspend fun saveImageToDB(appState: AppState) {
        remote.saveImageToDB(appState)
    }
}