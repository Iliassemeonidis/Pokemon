package com.example.pokemon.ui.main

import com.example.pokemon.interactor.Interactor
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.repository.main.Repository

class MainInteractor(
    private val remoteRepository: Repository<PokemonResultData>,
    private val localRepository: Repository<PokemonResultData>
) : Interactor<AppState> {

    // TODO написать реалтизацию и для localRepository
    override suspend fun getData(): AppState {
        return AppState.Success(remoteRepository.getData())
    }
}