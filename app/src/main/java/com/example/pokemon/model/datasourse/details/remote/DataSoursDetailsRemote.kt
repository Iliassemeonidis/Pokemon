package com.example.pokemon.model.datasourse.details.remote

interface DataSoursDetailsRemote<T> {
    suspend fun getPokemonImageData(isOnline: Boolean,url: String): T
}