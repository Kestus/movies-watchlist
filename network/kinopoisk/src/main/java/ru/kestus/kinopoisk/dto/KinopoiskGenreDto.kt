package ru.kestus.kinopoisk.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class KinopoiskGenreDto(
    @SerialName("genre") val value: String
)
