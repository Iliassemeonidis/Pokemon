package com.example.pokemon.model.datasourse.main

import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceLocal(private val remote: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSours<PokemonResultData> {

    override suspend fun getData() : PokemonResultData = remote.getData()
}