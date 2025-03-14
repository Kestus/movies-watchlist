package ru.kestus.movies_watchlist.data.network.kino.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("kinopoiskId") val idKino: Long,
    @SerializedName("nameRu") val nameRu: String?,
    @SerializedName("nameEn") val nameEn: String?,
    @SerializedName("nameOriginal") val nameOriginal: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("countries") val countries: List<CountryDto>,
    @SerializedName("genres") val genres: List<GenreDto>,
    @SerializedName("ratingKinopoisk") val ratingKino: Float?,
    @SerializedName("ratingImdb") val ratingImdb: Float?,
    @SerializedName("year") val year: Int?,
    @SerializedName("type") val type: String,
    @SerializedName("posterUrl") val posterUrl: String?
)
