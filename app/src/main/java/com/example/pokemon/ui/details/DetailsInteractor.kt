package com.example.pokemon.ui.details

import com.example.pokemon.interactor.InteractorDetails
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.repository.details.remote.RepositoryDetails

class DetailsInteractor(
    private val remoteRepository: RepositoryDetails<DetailsPokemonData>
) : InteractorDetails<AppState> {

    override suspend fun getImagePokemon(isOnline: Boolean, url: String): AppState {
        val appState: AppState
        if (isOnline) {
            appState = AppState.Success(remoteRepository.getImagePokemonData(isOnline,url))
            remoteRepository.saveImageToDB(appState)
        } else {
            appState = AppState.Success(remoteRepository.getImagePokemonData(isOnline,url))
        }
        return appState
    }
}