package ru.kestus.movies_watchlist.domain

import kotlinx.coroutines.flow.Flow
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem

interface Repository {

    fun loadPopularMovies(): Flow<List<PlainMovieItem>>

}