package ru.kestus.kinopoisk.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val kinopoiskId: Long,
    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val description: String?,
    val countries: List<CountryDto>,
    val genres: List<GenreDto>,
    val ratingKinopoisk: Float?,
    val ratingImdb: Float?,
    val year: Int?,
    val type: String,
    val posterUrl: String?
)
