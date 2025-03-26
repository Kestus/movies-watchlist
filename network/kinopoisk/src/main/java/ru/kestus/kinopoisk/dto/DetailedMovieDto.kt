package ru.kestus.kinopoisk.dto

import kotlinx.serialization.Serializable

@Serializable
data class DetailedMovieDto(
    val kinopoiskId: Int,
    val imdbId: String?,
    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val year: Int?,
    val filmLength: Int?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val coverUrl: String?,
    val logoUrl: String?,
    val ratingKinopoisk: Double?,
    val ratingImdb: Double?,
    val ratingGoodReview: Double?,
    val ratingFilmCritics: Double?,
    val webUrl: String,
    val description: String?,
    val shortDescription: String?,
    val type: String,
    val countries: List<CountryDto>,
    val genres: List<GenreDto>,
    val serial: Boolean?,
    val shortFilm: Boolean?
)