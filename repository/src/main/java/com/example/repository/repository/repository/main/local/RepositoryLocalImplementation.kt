package com.example.repository.repository.repository.main.local

import com.example.model.result.PokemonResultData
import com.example.repository.repository.datasourse.main.local.DataSoursLocal

class RepositoryLocalImplementation(private val dataSource: DataSoursLocal<PokemonResultData>) :
    RepositoryLocal<com.example.model.result.PokemonResultData> {

    override suspend fun saveToDB(appState: com.example.model.AppState) {
        dataSource.saveToDB(appState)
    }
}