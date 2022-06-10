package com.example.pokemon.model.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemon.model.data.result.PokemonResult
import com.example.pokemon.model.repository.room.HistoryDao

@Database(entities = [HistoryEntity::class], version = 1, exportSchema = false)
abstract class HistoryDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}