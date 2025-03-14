package ru.kestus.movies_watchlist.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.kestus.movies_watchlist.data.mapper.toPlainMovieItem
import ru.kestus.movies_watchlist.data.network.ApiFactory
import ru.kestus.movies_watchlist.data.network.kino.model.DetailedMovieDto
import ru.kestus.movies_watchlist.domain.Repository
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem
import java.io.File

class RepositoryImpl : Repository {

    private val apiService = ApiFactory.getService()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private var _loadedList = listOf<PlainMovieItem>()

    override fun loadPopularMovies(): Flow<List<PlainMovieItem>> = flow {
        val currentPage = _loadedList.size / 20
        val nextPage = currentPage + 1
        val nextList = fetchPage(nextPage)

        _loadedList = _loadedList.toMutableList().apply {
            addAll(nextList)
        }
        emit(_loadedList)
    }.stateIn(
        scope = ioScope,
        started = SharingStarted.Lazily,
        initialValue = _loadedList
    )

    private suspend fun fetchPage(page: Int): List<PlainMovieItem> {
        val response = apiService.getPopular(page)
        return response.items.map { it.toPlainMovieItem() }
    }

    fun testInterceptor() = ioScope.launch {
        val list = mutableListOf<DetailedMovieDto>()
        repeat(10) {
            val movie = apiService.getMovie(100+it)
            list.add(movie)
        }
        val file = File("interceptor.txt")
        for (movie in list) {
            file.writeText(movie.toString() + "\n", Charsets.UTF_16)
        }
    }

}