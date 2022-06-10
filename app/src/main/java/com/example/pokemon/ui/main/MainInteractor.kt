package com.example.pokemon.ui.main

import com.example.pokemon.interactor.Interactor
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.repository.main.remote.RepositoryMain

class MainInteractor(
    private val repository: RepositoryMain<PokemonResultData>
) : Interactor<AppState> {

    override suspend fun getData(isOnline: Boolean): AppState {
        val appState: AppState
        if (isOnline) {
            appState = AppState.Success(repository.getData(isOnline))
            repository.saveToDB(appState)
        } else {
            appState = AppState.Success(repository.getData(isOnline))
        }
        return appState
    }
}