package com.example.pokemon.model.repository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id") val id: Int,
    @field:ColumnInfo(name = "front_default") val frontDefault: String?,
)
