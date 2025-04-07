package ru.kestus.core.domain

import ru.kestus.core.domain.dto.MovieDetailsDto
import ru.kestus.core.domain.dto.MovieDto

interface MovieApiService {

    suspend fun getPopularMovies(page: Int = 1): List<MovieDto>

    suspend fun getMovieDetails(id: Int): MovieDetailsDto

}