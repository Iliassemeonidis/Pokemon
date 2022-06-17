package com.example.model.details

import com.google.gson.annotations.SerializedName

data class Sprites(
    @field:SerializedName("front_shiny") val frontShiny: String?,
    @field:SerializedName("other") val other: Other
)
