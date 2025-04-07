package ru.kestus.movies_watchlist.domain

import kotlinx.coroutines.flow.Flow
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem

interface Repository {

    val popularMovieFlow: Flow<List<PlainMovieItem>>

    fun getPopularMoviesFlow(): Flow<List<PlainMovieItem>>

    suspend fun loadNextPage()

}