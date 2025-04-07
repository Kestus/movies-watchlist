package ru.kestus.core.domain.dto

data class MovieDto(
    val idKinopoisk: Int,
    val nameOriginal: String,
    val nameEn: String?,
    val nameRu: String?,
    val description: String,
    val year: Int,
    val posterUrl: String,
    val genres: List<GenreDto>
)