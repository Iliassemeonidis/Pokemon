package com.example.repository.repository.repository.details.remote

import com.example.model.details.DetailsPokemonData
import com.example.repository.repository.datasourse.details.local.DataSoursDetailsLocal
import com.example.repository.repository.datasourse.details.remote.DataSoursDetailsRemote

class RepositoryDetailsImplementation(
    private val local: DataSoursDetailsLocal<DetailsPokemonData>,
    private val remote: DataSoursDetailsRemote<DetailsPokemonData>
) :
    RepositoryDetails<com.example.model.details.DetailsPokemonData> {

    override suspend fun getImagePokemonData(isOnline: Boolean, url: String): com.example.model.details.DetailsPokemonData {
        return remote.getPokemonImageData(isOnline, url)
    }
    override suspend fun saveImageToDB(appState: com.example.model.AppState) {
        local.saveImageToDB(appState)
    }
}