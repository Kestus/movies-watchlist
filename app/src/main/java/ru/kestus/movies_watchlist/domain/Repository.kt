package ru.kestus.movies_watchlist.domain

import ru.kestus.movies_watchlist.domain.items.PlainMovieItem

interface Repository {

    suspend fun getPopularMovies(): List<PlainMovieItem>

}