package ru.kestus.kinopoisk.dto

import kotlinx.serialization.Serializable

@Serializable
data class CollectionResponseDao(
    val total: Int,
    val totalPages: Int,
    val items: List<MovieDto>
)
