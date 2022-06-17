package com.example.repository.repository.datasourse

import com.example.model.details.DetailsPokemonData
import com.example.model.result.PokemonResultData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon?limit=100&offset=0")
    fun getDataPokemonAsync(): Deferred<com.example.model.result.PokemonResultData>

    @GET("pokemon/{url}/")
    fun getPokemonDetailsAsync(@Path("url") pokemonNumber: String): Deferred<com.example.model.details.DetailsPokemonData>
}