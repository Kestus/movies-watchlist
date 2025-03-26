package ru.kestus.movies_watchlist.presentation.viewModels

import androidx.lifecycle.ViewModel
import ru.kestus.movies_watchlist.data.RepositoryImpl

class MainViewModel : ViewModel() {

    private val repository = RepositoryImpl

    val popularMoviesFlow = repository.getPopularMoviesFlow()

}