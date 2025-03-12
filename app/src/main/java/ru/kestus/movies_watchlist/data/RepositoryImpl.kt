package ru.kestus.movies_watchlist.data

import android.app.Application
import kotlinx.coroutines.delay
import ru.kestus.movies_watchlist.domain.Repository
import ru.kestus.movies_watchlist.domain.items.PlainMovieItem

class RepositoryImpl(application: Application): Repository {

    override suspend fun getPopularMovies(): List<PlainMovieItem> {
        val list = mutableListOf<PlainMovieItem>()
        repeat(10) {
            list.add(PlainMovieItem("$it"))
        }
        delay(3000)
        return list
    }

}