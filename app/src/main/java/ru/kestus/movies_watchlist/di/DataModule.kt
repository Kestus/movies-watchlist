package ru.kestus.movies_watchlist.di

import dagger.Binds
import dagger.Module
import ru.kestus.movies_watchlist.data.RepositoryImpl
import ru.kestus.movies_watchlist.domain.Repository

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

}