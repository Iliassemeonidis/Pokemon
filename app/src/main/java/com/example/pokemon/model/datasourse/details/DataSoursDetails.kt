package com.example.pokemon.model.datasourse.details

interface DataSoursDetails <T> {
    suspend fun getPokemonImageData(url : String): T
}