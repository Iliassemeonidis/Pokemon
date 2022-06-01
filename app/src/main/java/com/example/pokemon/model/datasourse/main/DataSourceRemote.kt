package com.example.pokemon.model.datasourse.main

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RetrofitImplementation

class DataSourceRemote(private val remote: RetrofitImplementation) :
    DataSours<PokemonResultData, DetailsPokemonData> {

    override suspend fun getData(): PokemonResultData = remote.getData()

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        return remote.getPokemonImageData(url)
    }
}