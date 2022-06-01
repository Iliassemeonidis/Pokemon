package com.example.pokemon.interactor

interface Interactor<T> {
    suspend fun getData(isOnline : Boolean): T
}