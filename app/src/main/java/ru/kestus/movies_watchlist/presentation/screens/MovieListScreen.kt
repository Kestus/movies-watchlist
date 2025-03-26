package ru.kestus.movies_watchlist.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.kestus.movies_watchlist.domain.models.PlainMovieItem

@Composable
fun MovieListScreen(movies: List<PlainMovieItem>) {
    Column {
        for (i in 0 until 10) {
            val movie = movies.getOrNull(i) ?: break
            Text(
                text = movie.name
            )
        }
    }
}