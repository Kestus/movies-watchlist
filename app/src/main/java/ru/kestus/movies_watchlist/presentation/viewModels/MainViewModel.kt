package ru.kestus.movies_watchlist.presentation.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.kestus.movies_watchlist.data.RepositoryImpl
import ru.kestus.movies_watchlist.domain.Repository
import ru.kestus.movies_watchlist.domain.items.PlainMovieItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = RepositoryImpl(application)

    private val initialList = listOf<PlainMovieItem>()

    val moviesFlow = flow {
        val newList = repository.getPopularMovies()
        emit(newList)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = initialList
    )

}