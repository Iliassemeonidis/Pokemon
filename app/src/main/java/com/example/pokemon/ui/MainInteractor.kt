package com.example.pokemon.ui

import com.example.model.result.PokemonResultData
import com.example.repository.repository.repository.main.remote.RepositoryMain

class MainInteractor(
    private val repository: RepositoryMain<PokemonResultData>
) : com.example.core.Interactor<com.example.model.AppState> {

    override suspend fun getData(isOnline: Boolean): com.example.model.AppState {
        val appState: com.example.model.AppState
        if (isOnline) {
            appState = com.example.model.AppState.Success(repository.getData(isOnline))
            repository.saveToDB(appState)
        } else {
            appState = com.example.model.AppState.Success(repository.getData(isOnline))
        }
        return appState
    }
}