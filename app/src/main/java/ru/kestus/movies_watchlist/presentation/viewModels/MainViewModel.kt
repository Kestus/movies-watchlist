package ru.kestus.movies_watchlist.presentation.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.kestus.movies_watchlist.data.RepositoryImpl

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl()

    fun getMoviesFlow() = repository.loadPopularMovies()

    fun testInterceptor() = repository.testInterceptor()


}