package ru.kestus.movies_watchlist.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.kestus.movies_watchlist.presentation.screens.MoviesListScreen
import ru.kestus.movies_watchlist.presentation.ui.theme.MoviesWatchlistTheme
import ru.kestus.movies_watchlist.presentation.viewModels.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Set bottom nav bar transparent.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }
        setContent {
            MoviesWatchlistTheme {
                Scaffold { pv ->
                    Box(
                        modifier = Modifier.padding(pv)
                    ) {
                        val movies by viewModel.moviesFlow.collectAsState()
                        if (movies.isEmpty()) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        } else {
                            MoviesListScreen(movies)
                        }
                    }
                }
            }
        }
    }
}