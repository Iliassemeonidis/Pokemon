package com.example.pokemon.model.datasourse

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon?limit=100&offset=0")
    fun getDataPokemonAsync(): Deferred<PokemonResultData>

    @GET("pokemon/{url}/")
    fun getPokemonDetailsAsync(@Path("url") pokemonNumber: String): Deferred<DetailsPokemonData>
}