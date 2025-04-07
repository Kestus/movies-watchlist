package ru.kestus.kinopoisk.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class KinopoiskMovieDto(
    val kinopoiskId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val description: String?,
    val countries: List<KinopoiskCountryDto>,
    val genres: List<KinopoiskGenreDto>,
    val ratingKinopoisk: Float?,
    val ratingImdb: Float?,
    val year: Int?,
    val type: String,
    val posterUrl: String?
)
