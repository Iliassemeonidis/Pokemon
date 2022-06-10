package com.example.pokemon.model.datasourse.details.remote

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.RetrofitImplementation
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceDetailsRemoteImpl(
    private val remote: RetrofitImplementation,
    private val dataBase: RoomDataBaseImplementation
) : DataSoursDetailsRemote<DetailsPokemonData> {

    override suspend fun getPokemonImageData(isOnline: Boolean,url: String): DetailsPokemonData {
        if (!isOnline) {
            dataBase.getPokemonImageData(url)
        }
        return remote.getPokemonImageData(url)
    }

}