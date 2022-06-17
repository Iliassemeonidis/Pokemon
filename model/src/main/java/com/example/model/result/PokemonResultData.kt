package com.example.model.result

import com.google.gson.annotations.SerializedName

data class PokemonResultData(@field:SerializedName("results") val results: List<PokemonResult>?)
