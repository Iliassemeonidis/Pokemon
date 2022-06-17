package com.example.repository.repository.datasourse.main.remote

interface DataSoursRemote<T> {
    suspend fun getData(isOnline: Boolean): T
}