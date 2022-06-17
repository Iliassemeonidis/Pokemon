package com.example.repository.repository.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {

    @Query("SELECT*FROM HistoryEntity")
    suspend fun all(): List<HistoryEntity>

    @Query("SELECT*FROM ImageHistoryEntity")
    suspend fun getAll(): List<ImageHistoryEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: HistoryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: ImageHistoryEntity)
}