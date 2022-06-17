package com.example.detailsscreen.details.interactor

interface InteractorDetails<T> {
    suspend fun getImagePokemon(isOnline: Boolean,url: String): T
}