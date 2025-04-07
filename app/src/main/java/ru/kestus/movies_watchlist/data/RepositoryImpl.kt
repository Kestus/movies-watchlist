package ru.kestus.movies_watchlist.data

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.kestus.core.di.qualifier.KinopoiskApiServiceQualifier
import ru.kestus.core.domain.MovieApiService
import ru.kestus.movies_watchlist.data.mapper.toPlainMovieItem
import ru.kestus.movies_watchlist.domain.Repository
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    @KinopoiskApiServiceQualifier private val kinopoiskApiService: MovieApiService
) : Repository {

    private val ioScope = CoroutineScope(Dispatchers.IO)

    private var nextPageNumber = 1

    private var _movieList = mutableListOf<PlainMovieItem>()

    private val loadNexPageEvent = MutableSharedFlow<Unit>()

    override val popularMovieFlow: Flow<List<PlainMovieItem>> by lazy {
        flow {
            fetchPage(nextPageNumber++)
            emit(_movieList.toList())

            loadNexPageEvent.collect {
                Log.d("TAG", "loadNexPageEvent: collect")
                fetchPage(nextPageNumber++)
                emit(_movieList.toList())
            }
        }.stateIn(
            scope = ioScope,
            started = SharingStarted.Lazily,
            initialValue = _movieList.toList()
        )
    }

    override fun getPopularMoviesFlow() = popularMovieFlow

    override suspend fun loadNextPage() {
        Log.d("TAG", "loadNexPageEvent: emit")
        loadNexPageEvent.emit(Unit)
    }

    private suspend fun fetchPage(page: Int) {
        val response = kinopoiskApiService.getPopularMovies(page)
        _movieList.addAll(
            response.map { it.toPlainMovieItem() }
        )
    }

}