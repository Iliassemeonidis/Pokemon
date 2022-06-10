package com.example.pokemon.model.datasourse.main.remote

import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RetrofitImplementation
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation

class DataSourceRemoteImpl(
    private val remote: RetrofitImplementation,
    private val dataBase: RoomDataBaseImplementation
) : DataSoursRemote<PokemonResultData> {

    override suspend fun getData(isOnline: Boolean): PokemonResultData {
        if (!isOnline) {
            return dataBase.getData()
        }
        return remote.getData()
    }
}