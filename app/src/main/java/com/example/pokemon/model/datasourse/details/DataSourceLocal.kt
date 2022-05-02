package com.example.pokemon.model.datasourse.details

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceLocal(private val remote: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSoursDetails<DetailsPokemonData> {

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        return remote.getPokemonImageData(url)
    }
}