package com.example.pokemon.model.datasourse.details

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.RetrofitImplementation

class DataSourceRemote(private val remote: RetrofitImplementation = RetrofitImplementation()) :
    DataSoursDetails<DetailsPokemonData> {

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        return remote.getPokemonImageData(url)
    }
}