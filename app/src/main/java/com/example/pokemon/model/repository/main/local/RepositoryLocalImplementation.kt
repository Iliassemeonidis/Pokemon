package com.example.pokemon.model.repository.main.local

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.main.local.DataSoursLocal

class RepositoryLocalImplementation(private val dataSource: DataSoursLocal<PokemonResultData>) :
    RepositoryLocal<PokemonResultData> {

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}