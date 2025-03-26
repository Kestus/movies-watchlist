package ru.kestus.movies_watchlist.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.kestus.kinopoisk.KinopoiskClient
import ru.kestus.movies_watchlist.data.mapper.toPlainMovieItem
import ru.kestus.movies_watchlist.domain.Repository
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem


object RepositoryImpl : Repository {

    private val apiService = KinopoiskClient()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val popularMovieFlow: Flow<List<PlainMovieItem>> by lazy {
        flow {
            emit(fetchPage(1))
        }.stateIn(
            scope = ioScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )
    }

    override fun getPopularMoviesFlow() = popularMovieFlow

    private suspend fun fetchPage(page: Int): List<PlainMovieItem> {
        val response = apiService.getPopularMovies(page)
        return response.map { it.toPlainMovieItem() }
    }

}