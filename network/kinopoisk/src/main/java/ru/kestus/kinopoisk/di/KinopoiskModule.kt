package ru.kestus.kinopoisk.di

import dagger.Binds
import dagger.Module
import ru.kestus.core.di.qualifier.KinopoiskApiServiceQualifier
import ru.kestus.core.domain.MovieApiService
import ru.kestus.kinopoisk.KinopoiskApiService

@Module
interface KinopoiskModule {

    @Binds
    @KinopoiskApiServiceQualifier
    fun bindKinopoiskApiService(impl: KinopoiskApiService): MovieApiService

}