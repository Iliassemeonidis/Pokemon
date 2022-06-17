package com.example.repository.repository.datasourse.details.remote

import com.example.repository.repository.datasourse.RetrofitImplementation
import com.example.repository.repository.datasourse.RoomDataBaseImplementation

class DataSourceDetailsRemoteImpl(
    private val remote: RetrofitImplementation,
    private val dataBase: RoomDataBaseImplementation
) : DataSoursDetailsRemote<com.example.model.details.DetailsPokemonData> {

    override suspend fun getPokemonImageData(isOnline: Boolean,url: String): com.example.model.details.DetailsPokemonData {
        if (!isOnline) {
            dataBase.getPokemonImageData(url)
        }
        return remote.getPokemonImageData(url)
    }

}