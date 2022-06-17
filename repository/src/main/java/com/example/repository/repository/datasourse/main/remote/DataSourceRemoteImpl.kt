package com.example.repository.repository.datasourse.main.remote

import com.example.repository.repository.datasourse.RetrofitImplementation
import com.example.repository.repository.datasourse.RoomDataBaseImplementation

class DataSourceRemoteImpl(
    private val remote: RetrofitImplementation,
    private val dataBase: RoomDataBaseImplementation
) : DataSoursRemote<com.example.model.result.PokemonResultData> {

    override suspend fun getData(isOnline: Boolean): com.example.model.result.PokemonResultData {
        if (!isOnline) {
            return dataBase.getData()
        }
        return remote.getData()
    }
}