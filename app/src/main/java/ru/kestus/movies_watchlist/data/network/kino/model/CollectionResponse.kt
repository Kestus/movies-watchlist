package ru.kestus.movies_watchlist.data.network.kino.model

import com.google.gson.annotations.SerializedName

data class CollectionResponse(
    @SerializedName("total") val total: Int,
    @SerializedName("totalPages") val totalPages: Int,
    @SerializedName("items") val items: List<MovieDto>
)
