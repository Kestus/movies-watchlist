package ru.kestus.movies_watchlist.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.kestus.core.di.scope.ApplicationScope
import ru.kestus.kinopoisk.di.KinopoiskModule
import ru.kestus.movies_watchlist.presentation.MainActivity


@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        KinopoiskModule::class,
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }

}