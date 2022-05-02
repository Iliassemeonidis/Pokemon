package com.example.pokemon.model.repository.details

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.datasourse.details.DataSoursDetails

class RepositoryDetailsImplementation(private val pokemon: DataSoursDetails<DetailsPokemonData>) :
    RepositoryDetails<DetailsPokemonData> {

    override suspend fun getImagePokemonData(url: String): DetailsPokemonData {
        return pokemon.getPokemonImageData(url)
    }
}