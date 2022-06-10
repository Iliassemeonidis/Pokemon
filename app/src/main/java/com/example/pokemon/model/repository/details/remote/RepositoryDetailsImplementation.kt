package com.example.pokemon.model.repository.details.remote

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.details.local.DataSoursDetailsLocal
import com.example.pokemon.model.datasourse.details.remote.DataSoursDetailsRemote

class RepositoryDetailsImplementation(
    private val local: DataSoursDetailsLocal<DetailsPokemonData>,
    private val remote: DataSoursDetailsRemote<DetailsPokemonData>
) :
    RepositoryDetails<DetailsPokemonData> {

    override suspend fun getImagePokemonData(isOnline: Boolean, url: String): DetailsPokemonData {
        return remote.getPokemonImageData(isOnline, url)
    }

    override suspend fun saveToDB(appState: AppState) {
        local.saveToDB(appState)
    }
}