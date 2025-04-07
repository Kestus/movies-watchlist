package ru.kestus.movies_watchlist.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kestus.movies_watchlist.di.key.ViewModelKey
import ru.kestus.movies_watchlist.presentation.viewModel.MainViewModel

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel

}