package com.example.repository.repository.repository

import com.example.repository.repository.repository.room.HistoryEntity
import com.example.repository.repository.repository.room.ImageHistoryEntity

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): com.example.model.result.PokemonResultData {
    val pokemonResultList = ArrayList<com.example.model.result.PokemonResult>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            pokemonResultList.add(com.example.model.result.PokemonResult(entity.name, entity.url))
        }
    }
    return com.example.model.result.PokemonResultData(pokemonResultList)
}

fun mapImageEntityToSearchResult(list: List<ImageHistoryEntity>): com.example.model.details.DetailsPokemonData {
    val pokemonResultList = ArrayList<com.example.model.details.DetailsPokemonData>()
    list.let {
        it.forEach { entity ->
            val sprites = com.example.model.details.Sprites(
                "",
                com.example.model.details.Other(
                    com.example.model.details.DreamWorld(
                        entity.frontDefault ?: ""
                    )
                )
            )
            pokemonResultList.add(com.example.model.details.DetailsPokemonData(sprites))
        }
    }
    return com.example.model.details.DetailsPokemonData(pokemonResultList[0].sprites)
}


fun convertDataModelSuccessToEntity(appState: com.example.model.AppState): HistoryEntity? {
    return when (appState) {
        is com.example.model.AppState.Success -> {
            val searchResult = appState.data as com.example.model.result.PokemonResultData
            if (searchResult.results.isNullOrEmpty() || searchResult.results!![0].name.isNullOrEmpty()) {
                null
            } else {
                HistoryEntity(0, searchResult.results!![0].name!!, searchResult.results!![0].url!!)
            }
        }
        else -> null
    }
}

