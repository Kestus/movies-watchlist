package ru.kestus.movies_watchlist.data.mapper

import ru.kestus.kinopoisk.dto.MovieDto
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem

fun MovieDto.toPlainMovieItem(): PlainMovieItem {
    val selectName = nameOriginal ?: nameEn ?: nameRu ?: "NoName"

    return PlainMovieItem(
        id = kinopoiskId,
        name = selectName,
        description = description ?: "",
        year = year ?: 0,
        genres = genres.map { it.value },
        posterUrl = posterUrl,
    )
}
