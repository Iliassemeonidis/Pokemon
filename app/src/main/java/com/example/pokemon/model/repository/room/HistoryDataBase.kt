package com.example.pokemon.model.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 2,
    entities = [HistoryEntity::class, ImageHistoryEntity::class],
    exportSchema = true
)
abstract class HistoryDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}