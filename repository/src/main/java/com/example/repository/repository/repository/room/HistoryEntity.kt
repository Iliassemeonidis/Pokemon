package com.example.repository.repository.repository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id") val id: Int,
    @field:ColumnInfo(name = "name") val name: String?,
    @field:ColumnInfo(name = "url") val url: String?
)

