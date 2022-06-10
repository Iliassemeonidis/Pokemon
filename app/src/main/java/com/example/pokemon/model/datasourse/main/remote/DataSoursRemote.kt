package com.example.pokemon.model.datasourse.main.remote

interface DataSoursRemote<T> {
    suspend fun getData(isOnline: Boolean): T
}