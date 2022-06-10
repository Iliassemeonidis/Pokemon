package com.example.pokemon.model.repository.main.remote

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.main.local.DataSoursLocal
import com.example.pokemon.model.datasourse.main.remote.DataSoursRemote

class RepositoryMainImplementation(
    private val dataSourceRemote: DataSoursRemote<PokemonResultData>,
    private val dataSourceLocal: DataSoursLocal<PokemonResultData>,
) : RepositoryMain<PokemonResultData> {

    override suspend fun getData(isOnline: Boolean): PokemonResultData {
        return dataSourceRemote.getData(isOnline)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSourceLocal.saveToDB(appState)
    }
}