package ru.kestus.movies_watchlist.data.network.kino.model

import com.google.gson.annotations.SerializedName


data class CountryDto(
    @SerializedName("country") val value: String
)