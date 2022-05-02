package com.example.pokemon.model.datasourse

import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.details.DataSoursDetails
import com.example.pokemon.model.datasourse.main.DataSours

class RoomDataBaseImplementation() : DataSours<PokemonResultData> ,
    DataSoursDetails<DetailsPokemonData> {

    override suspend fun getData(): PokemonResultData {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        TODO("Not yet implemented")
    }
}