package com.example.pokemon.model.datasourse.main

interface DataSours<T> {
    suspend fun getData(): T
}