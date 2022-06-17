package com.example.repository.repository.datasourse.details.remote

interface DataSoursDetailsRemote<T> {
    suspend fun getPokemonImageData(isOnline: Boolean,url: String): T
}