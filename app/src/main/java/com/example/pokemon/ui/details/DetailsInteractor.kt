package com.example.pokemon.ui.details

import com.example.pokemon.interactor.InteractorDetails
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.repository.details.RepositoryDetails

class DetailsInteractor(
    private val remoteRepository: RepositoryDetails<DetailsPokemonData>,
    private val localRepository: RepositoryDetails<DetailsPokemonData>
) : InteractorDetails<AppState> {

    override suspend fun getImagePokemon(url: String): AppState {
        //TODO реализовать и для локального репозитория
        return AppState.Success(remoteRepository.getImagePokemonData(url))
    }
}