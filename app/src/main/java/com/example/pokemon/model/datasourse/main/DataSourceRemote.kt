package com.example.pokemon.model.datasourse.main

import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RetrofitImplementation

class DataSourceRemote(private val remote: RetrofitImplementation = RetrofitImplementation()) :
    DataSours<PokemonResultData> {
    override suspend fun getData(): PokemonResultData = remote.getData()
}