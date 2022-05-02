package com.example.pokemon.model.repository.main

// Репозиторий представляет собой слой получения и хранения данных
interface Repository<T> {
    suspend fun getData():T
}