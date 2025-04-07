package ru.kestus.kinopoisk

import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.kestus.core.domain.MovieApiService
import ru.kestus.core.domain.dto.MovieDetailsDto
import ru.kestus.core.domain.dto.MovieDto
import ru.kestus.kinopoisk.dto.KinopoiskCollectionResponseDto
import ru.kestus.kinopoisk.dto.KinopoiskDetailedMovieDto
import ru.kestus.kinopoisk.mapper.toMovieDetailedDto
import ru.kestus.kinopoisk.mapper.toMovieDto
import javax.inject.Inject

class KinopoiskApiService @Inject constructor() : MovieApiService {

    private var requestsCount = 0

    private val client by lazy {
        KtorClient(
            baseUrl = KINO_BASE_URL,
            requestHeaders = listOf(
                "Content-Type" to "application/json",
                "X-API-KEY" to BuildConfig.API_KEY
            )
        ).client()
    }

    override suspend fun getPopularMovies(page: Int): List<MovieDto> {
        if (requestsCount >= 3) throw RuntimeException("req")
        requestsCount++
        val result = client.get("films/collections?type=TOP_POPULAR_MOVIES") {
            url {
                parameters.append("page", page.toString())
            }
        }.body<KinopoiskCollectionResponseDto>()
        return result.items.map { it.toMovieDto() }
    }

    override suspend fun getMovieDetails(id: Int): MovieDetailsDto {
        if (requestsCount >= 3) throw RuntimeException("req")
        requestsCount++
        return client.get("films/$id").body<KinopoiskDetailedMovieDto>().toMovieDetailedDto()
    }

    companion object {
        private const val KINO_BASE_URL = "https://kinopoiskapiunofficial.tech/api/v2.2/"
    }

}