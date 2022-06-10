package com.example.pokemon.model.data.result

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonResult(
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("url") val url: String?
): Serializable