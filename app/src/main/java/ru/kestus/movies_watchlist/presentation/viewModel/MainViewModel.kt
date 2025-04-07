package ru.kestus.movies_watchlist.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import ru.kestus.movies_watchlist.domain.Repository
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val popularMoviesFlow = repository.popularMovieFlow

    val state = MutableStateFlow<List<PlainMovieItem>>(emptyList())
        .mergeWith(popularMoviesFlow)


    fun loadNextPage() {
        viewModelScope.launch {
            repository.loadNextPage()
        }
    }

    private fun <T> Flow<T>.mergeWith(flow: Flow<T>): Flow<T> {
        return merge(this, flow)
    }

}