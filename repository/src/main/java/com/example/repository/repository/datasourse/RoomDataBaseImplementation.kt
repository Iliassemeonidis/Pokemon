package com.example.repository.repository.datasourse

import com.example.model.AppState
import com.example.model.details.DetailsPokemonData
import com.example.model.result.PokemonResultData
import com.example.repository.repository.datasourse.details.local.DataSoursDetailsLocal
import com.example.repository.repository.datasourse.main.local.DataSoursLocal
import com.example.repository.repository.repository.mapHistoryEntityToSearchResult
import com.example.repository.repository.repository.mapImageEntityToSearchResult
import com.example.repository.repository.repository.room.HistoryDao
import com.example.repository.repository.repository.room.HistoryEntity
import com.example.repository.repository.repository.room.ImageHistoryEntity

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSoursLocal<PokemonResultData>, DataSoursDetailsLocal<DetailsPokemonData> {

    override suspend fun saveToDB(appState: AppState) {
        when (appState) {
            is com.example.model.AppState.Success -> {
                val data = appState.data as com.example.model.result.PokemonResultData
                data.results?.let {
                    it.forEach { entity ->
                        historyDao.insert(HistoryEntity(0, entity.name, entity.url))
                    }
                }
            }
            else -> {}
        }
    }

    override suspend fun getData(): com.example.model.result.PokemonResultData {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun getPokemonImageData(url: String): com.example.model.details.DetailsPokemonData {
        return mapImageEntityToSearchResult(historyDao.getAll())
    }

    //TODO понять как сейвить svg файл так как щас сохраняется ссылка на картинку
    override suspend fun saveImageToDB(appState: com.example.model.AppState) {
        when (appState) {
            is com.example.model.AppState.Success -> {
                val data = appState.data as com.example.model.details.DetailsPokemonData
                historyDao.insert(ImageHistoryEntity(0, data.sprites.other.dream.frontDefault))
            }
            else -> {}
        }
    }
}