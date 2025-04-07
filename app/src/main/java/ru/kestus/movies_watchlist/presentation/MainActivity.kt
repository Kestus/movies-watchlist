package ru.kestus.movies_watchlist.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.kestus.movies_watchlist.MoviesApplication
import ru.kestus.movies_watchlist.R
import ru.kestus.movies_watchlist.presentation.screens.MovieListScreen
import ru.kestus.movies_watchlist.presentation.ui.theme.MoviesWatchlistTheme
import ru.kestus.movies_watchlist.presentation.viewModel.AppViewModelFactory
import ru.kestus.movies_watchlist.presentation.viewModel.MainViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as MoviesApplication).component
    }

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Set bottom nav bar transparent.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }
        setContent {
            MoviesWatchlistTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                viewModel.loadNextPage()
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_refresh),
                                contentDescription = null
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) { pv ->
                    val movies = viewModel.state.collectAsStateWithLifecycle(emptyList())
                    Box(
                        modifier = Modifier.padding(pv)
                    ) {
                        if (movies.value.isEmpty()) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        } else {
                            MovieListScreen(movies.value)
                        }
                    }
                }
            }
        }
    }
}