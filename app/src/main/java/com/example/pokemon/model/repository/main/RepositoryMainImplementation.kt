package com.example.pokemon.model.repository.main

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.main.DataSours

class RepositoryMainImplementation(private val dataSource: DataSours<PokemonResultData, DetailsPokemonData>) :
    RepositoryMain<PokemonResultData> {

    override suspend fun getData(): PokemonResultData {
        return dataSource.getData()
    }

    override suspend fun saveToDB(appState: AppState) {
       dataSource.saveToDB(appState)
    }
}