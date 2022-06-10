package com.example.pokemon.model.datasourse

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.details.local.DataSoursDetailsLocal
import com.example.pokemon.model.datasourse.main.local.DataSoursLocal
import com.example.pokemon.model.repository.mapHistoryEntityToSearchResult
import com.example.pokemon.model.repository.mapImageEntityToSearchResult
import com.example.pokemon.model.repository.room.HistoryDao
import com.example.pokemon.model.repository.room.HistoryEntity
import com.example.pokemon.model.repository.room.ImageHistoryEntity

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSoursLocal<PokemonResultData>, DataSoursDetailsLocal<DetailsPokemonData> {

    override suspend fun saveToDB(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val data = appState.data as PokemonResultData
                data.results?.let {
                    it.forEach { entity ->
                        historyDao.insert(HistoryEntity(0, entity.name, entity.url))
                    }
                }
            }
            else -> {}
        }
    }

    override suspend fun getData(): PokemonResultData {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun getPokemonImageData(url: String): DetailsPokemonData {
        return mapImageEntityToSearchResult(historyDao.getAll())
    }

    //TODO понять как сейвить svg файл так как щас сохраняется ссылка на картинку
    override suspend fun saveImageToDB(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val data = appState.data as DetailsPokemonData
                historyDao.insert(ImageHistoryEntity(0, data.sprites.other.dream.frontDefault))
            }
            else -> {}
        }
    }
}