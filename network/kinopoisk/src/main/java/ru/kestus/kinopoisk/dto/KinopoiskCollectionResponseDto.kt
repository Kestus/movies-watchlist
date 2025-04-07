package ru.kestus.kinopoisk.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class KinopoiskCollectionResponseDto(
    val total: Int,
    val totalPages: Int,
    val items: List<KinopoiskMovieDto>
)
