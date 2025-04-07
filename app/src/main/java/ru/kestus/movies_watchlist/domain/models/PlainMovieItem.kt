package ru.kestus.movies_watchlist.domain.models

data class PlainMovieItem(
    val id: Long,
    val idKinopoisk: Int,
    val name: String,
    val description: String,
    val year: Int,
    val genres: List<String>,
    val posterUrl: String
)
