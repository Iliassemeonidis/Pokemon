package com.example.core

interface Interactor<T> {
    suspend fun getData(isOnline : Boolean): T
}