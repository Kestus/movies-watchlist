package ru.kestus.movies_watchlist

import android.app.Application
import ru.kestus.movies_watchlist.di.DaggerApplicationComponent

class MoviesApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}