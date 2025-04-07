package ru.kestus.kinopoisk.mapper

import ru.kestus.core.domain.dto.GenreDto
import ru.kestus.core.domain.dto.MovieDetailsDto
import ru.kestus.core.domain.dto.MovieDto
import ru.kestus.kinopoisk.dto.KinopoiskDetailedMovieDto
import ru.kestus.kinopoisk.dto.KinopoiskMovieDto

internal fun KinopoiskMovieDto.toMovieDto(): MovieDto = MovieDto(
    idKinopoisk = kinopoiskId,
    nameEn = nameEn ?: nameRu ?: nameOriginal ?: "null",
    nameOriginal = nameOriginal ?: "",
    nameRu = nameRu,
    description = description ?: "",
    year = year ?: 0,
    posterUrl = posterUrl ?: "",
    genres = genres.map { GenreDto(it.value) }
)

internal fun KinopoiskDetailedMovieDto.toMovieDetailedDto(): MovieDetailsDto = MovieDetailsDto(
    idKinopoisk = kinopoiskId,
    name = nameEn ?: nameRu ?: nameOriginal ?: "null",
    originalName = nameOriginal ?: "null"
)