package com.example.detailsscreen.details

import com.example.detailsscreen.details.interactor.InteractorDetails
import com.example.model.AppState
import com.example.model.details.DetailsPokemonData
import com.example.repository.repository.repository.details.remote.RepositoryDetails

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