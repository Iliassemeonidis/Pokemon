package com.example.pokemon.model.datasourse

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.details.DataSoursDetails
import com.example.pokemon.model.datasourse.main.DataSours
import com.example.pokemon.model.repository.mapHistoryEntityToSearchResult
import com.example.pokemon.model.repository.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSours<AppState, DetailsPokemonData>,
    DataSoursDetails<DetailsPokemonData> {

    override suspend fun getData(): AppState {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        TODO("Not yet implemented")
    }

    override suspend fun saveToDB(appState: AppState) {
        historyDao.insert()
    }
}