package com.example.repository.repository.repository.main.remote

import com.example.model.result.PokemonResultData
import com.example.repository.repository.datasourse.main.local.DataSoursLocal
import com.example.repository.repository.datasourse.main.remote.DataSoursRemote

class RepositoryMainImplementation(
    private val dataSourceRemote: DataSoursRemote<PokemonResultData>,
    private val dataSourceLocal: DataSoursLocal<PokemonResultData>,
) : RepositoryMain<com.example.model.result.PokemonResultData> {

    override suspend fun getData(isOnline: Boolean): com.example.model.result.PokemonResultData {
        return dataSourceRemote.getData(isOnline)
    }

    override suspend fun saveToDB(appState: com.example.model.AppState) {
        dataSourceLocal.saveToDB(appState)
    }
}