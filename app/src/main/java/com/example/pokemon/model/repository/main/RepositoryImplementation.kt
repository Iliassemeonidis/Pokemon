package com.example.pokemon.model.repository.main

import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.main.DataSours

class RepositoryImplementation(private val dataSource: DataSours<PokemonResultData>) :
    Repository<PokemonResultData> {

    override suspend fun getData(): PokemonResultData {
        return dataSource.getData()
    }
}