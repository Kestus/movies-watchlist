package ru.kestus.movies_watchlist.data.mapper

import ru.kestus.core.domain.dto.MovieDto
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem
import kotlin.random.Random

fun MovieDto.toPlainMovieItem(): PlainMovieItem = PlainMovieItem(
    id = Random(196).nextLong(),
    idKinopoisk = idKinopoisk,
    name = nameOriginal,
    description = description,
    year = year,
    genres = genres.map { it.value },
    posterUrl = posterUrl,
)
