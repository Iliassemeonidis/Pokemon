package com.example.pokemon.model.data

sealed class AppState {
    data class Success(val data: Any) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}