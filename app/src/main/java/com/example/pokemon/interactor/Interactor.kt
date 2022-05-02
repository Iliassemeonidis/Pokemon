package com.example.pokemon.interactor

interface Interactor<T> {
    suspend fun getData() : T
}