package com.example.pokemon.model.repository

import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.details.DreamWorld
import com.example.pokemon.model.data.details.Other
import com.example.pokemon.model.data.details.Sprites
import com.example.pokemon.model.data.result.PokemonResult
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.repository.room.HistoryEntity
import com.example.pokemon.model.repository.room.ImageHistoryEntity

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): PokemonResultData {
    val pokemonResultList = ArrayList<PokemonResult>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            pokemonResultList.add(PokemonResult(entity.name, entity.url))
        }
    }
    return PokemonResultData(pokemonResultList)
}

fun mapImageEntityToSearchResult(list: List<ImageHistoryEntity>): DetailsPokemonData {
    val pokemonResultList = ArrayList<DetailsPokemonData>()
    list.let {
        it.forEach { entity ->
            val sprites = Sprites("", Other(DreamWorld(entity.frontDefault ?: "")))
            pokemonResultList.add(DetailsPokemonData(sprites))
        }
    }
    return DetailsPokemonData(pokemonResultList[0].sprites)
}


fun convertDataModelSuccessToEntity(appState: AppState): HistoryEntity? {
    return when (appState) {
        is AppState.Success -> {
            val searchResult = appState.data as PokemonResultData
            if (searchResult.results.isNullOrEmpty() || searchResult.results[0].name.isNullOrEmpty()) {
                null
            } else {
                HistoryEntity(0, searchResult.results[0].name!!, searchResult.results[0].url!!)
            }
        }
        else -> null
    }
}

